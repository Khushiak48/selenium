#############################################################################
#Author:		ak
##
#############################################################################
@Stage1 @Location @Parameterization @RIB
Feature: Location stage1 messages
AS-A-CLIENT:		Of the Integration Layer
I-WANT-TO:			Test the consumption of Location messages in RIB xml format
SO-THAT-I:			Verify the message was processed correctly

  Background: List of steps run before each of the scenarios
    Given The Azure storage account with the following credentials is accessible
      | storageEndpointProtocol | ${azure.storage.storageEndpointProtocol} |
      | storageAccountName      | ${azure.storage.storageAccountName}      |
      | storageAccountKey       | ${azure.storage.storageAccountKey}       |
    And The Azure storage account has the following queues defined for each type of logger
      | EventLoggerQueue             | ${azurestorage.stage1.EventQueueName}             |
      | MessageLoggerQueue           | ${azurestorage.stage1.MessageQueueName}           |
      | FlowStepLoggerQueue          | ${azurestorage.stage1.FlowstepQueueName}          |
      | SystemInteractionLoggerQueue | ${azurestorage.stage1.SystemIntegrationQueueName} |
    ##	Initialise mule(application) flows
    And Initialise mule flows
    ##	Delete all previous incoming messages in Queue Storage
    And The messages are cleared from all the logger queues
    ##	Delete all previous incoming messages in Table Storage
    And The table called "${azurestorage.table.storage.name}" is truncated
    ##	Delete all previous message payloads in Blob Storage
    And The contents from folder named "${azure.storage.blob.source.dir}" within the blob container called "${azure.storage.blob.container.name}" is deleted
  
  #####################################################################################################
  ##Scenario1:Happy path scenario for store message consumption into Mule for Stage 1
  ##
  ##############################################################################################    
  
  @Location @RIB @Succeeds
  Scenario Outline: Process Location <InputFileName> message succeeds
    Given The given RIB message
      | sourcefileDirectory | .\\src\\test\\resources\\TestInput\\ | 
      | fileName            | <InputFileName>                  | 
      And Upload a message to JMS topic
      And The message is sent successfully
  ##	Wait for a while until the flow has completed
     When We wait for 60000 milliseconds
     Then A message has been persisted in table storage in the table called "${azurestorage.table.storage.name}" which contain 1 entity and below properties
  ##  Inherited Table Entity Properties
      | PartitionKey | <InputPartitionKey> | 
  ##  Core Message Properties
      | blobContainerName        | ${azure.storage.blob.container.name}                                                                                                                                                                                                                             | 
      | blobName                 | ${azure.storage.blob.source.dir}/<InputFileName>                                                                                                                                                                                                                 | 
      | messageContentType       | text/xml                                                                                                                                                                                                                                                         | 
      | sourceSystemApplication  | oracle.rms.rib                                                                                                                                                                                                                                                   | 
      | sourceSystemDomain       | bandm                                                                                                                                                                                                                                                            | 
      | sourceSystemFullName     | com.asos.bandm.oracle.rms.rib.15                                                                                                                                                                                                                                 | 
      | sourceSystemOrganisation | com.asos                                                                                                                                                                                                                                                         | 
      | sourceSystemVersion      | 15                                                                                                                                                                                                                                                               | 
      | targetSystemApplication  | intplat.mule.int006e                                                                                                                                                                                                                                             | 
      | targetSystemDomain       | intplatform                                                                                                                                                                                                                                                      | 
      | targetSystemFullName     | com.asos.intplatform.intplat.mule.int006e.0.1                                                                                                                                                                                                                    | 
      | targetSystemOrganisation | com.asos                                                                                                                                                                                                                                                         | 
      | targetSystemVersion      | 0.1                                                                                                                                                                                                                                                              | 
      | transportPropertiesJson  | {\\"JMSPriority\\":0,\\"JMSMessageID\\":\\"ID:Rudhira-64998-1487342296801-1:2:1:1:1\\",\\"JMSDestination\\":\\"topic://etStoresFromRMS\\",\\"JMSExpiration\\":1487342382464,\\"JMSRedelivered\\":false,\\"JMSTimestamp\\":1487342377464,\\"JMSDeliveryMode\\":1} | 
      | transportProtocol        | tcp                                                                                                                                                                                                                                                              | 
  ###############################################################################################################
  ##	Check if the incoming message was processed and persisted to Azure Storage
  ##  A single entry should have been written to Table Storage containing the message meta data
  ##  A single item should have been written to BLOB Storage containing the message XML payload
  ##
  ###############################################################################################################
  ##
  ##  Verify the Original Message was persisted to Blob Storage
      And A call is made to list the blobs in container "${azure.storage.blob.container.name}"
    ##And The list of blobs contains 1 blob
    And The blob is a directory called "${azure.storage.blob.source.dir}/"
    And The blob directory "${azure.storage.blob.source.dir}/" contains 1 blob
    ##And The blob content is the same as the input message
  ###############################################################################################################
  ##	Check if the appropriate logs were written to Azure
  ##	Each integration is expected to generate the following minimum logs:
  ##  	2+ System Interaction logs - The incoming and outgoing system interactions
  ##  	2+ Message logs - The incoming and outgoing messages
  ##  	3+ Flow Step logs - The minimum number of flow steps corresponding to the in-out-processing pattern
  ##  	2+ Event logs - At a minimum the start and end of the application should raise events
  ###############################################################################################################
  ##
  ##	Check if the Event Start log was written to Azure
      And After at least 2 messages are read from the "${azurestorage.stage1.EventQueueName}" and retrieve available messages
      And A log message was sent to the "${azurestorage.stage1.EventQueueName}" which contains
      | eventTypeName         | bam-orms-locsv-006e-stage1-incoming-file.start         | 
      | businessEntityID      | bam006.location        | 
      | messageSchemaVersion  | 1.0                    | 
      | entityID              | bam006                 | 
      | messageSchemaName     | IntegrationEvent       | 
      | sourceApplicationName | MuleESB-ORMS           | 
      | version               | 1                      | 
      | eventCode             | 0                      | 
      | flowID                | bam-orms-locsv-006e    | 
      | sourceDomainName      | com.asos.bam           | 
    
  ##
  ##	Check if the Event End log was written to Azure
       And A log message was sent to the "${azurestorage.stage1.EventQueueName}" which contains
      | eventTypeName         | bam-orms-locsv-006e-stage1-incoming-file.start         | 
      | businessEntityID      | bam006.location        | 
      | messageSchemaVersion  | 1.0                    | 
      | entityID              | bam006                 | 
      | messageSchemaName     | IntegrationEvent       | 
      | sourceApplicationName | MuleESB-ORMS           | 
      | version               | 1                      | 
      | eventCode             | 0                      | 
      | flowID                | bam-orms-locsv-006e    | 
      | sourceDomainName      | com.asos.bam           | 
  ##	Check if the System Interaction Inbound log was written to Azure
      And After at least 2 messages are read from the "${azurestorage.stage1.SystemIntegrationQueueName}" and retrieve available messages
      And A log message was sent to the "${azurestorage.stage1.SystemIntegrationQueueName}" which contains
      | targetApplicationName     | Location Integration Service         | 
      | systemID                  | 237                                  | 
      | messageSchemaVersion      | 1.0                                  | 
      | messageSchemaName         | SytemInteraction                     | 
      | sourceApplicationName     | MuleESB-ORMS                   | 
      | sourceApplicationVersion  |16                                    | 
      | targetDomainName          | com.asos.ip                          | 
      | flowID                    | bam-orms-locsv-006e                  | 
      | sourceDomainName          | com.asos.bam                         | 
  ##	Check if the System Interaction Outbound log was written to Azure
      And A log message was sent to the "${azurestorage.stage1.SystemIntegrationQueueName}" which contains
   | targetApplicationName        | Location Integration Service         | 
      | systemID                  | 237                                  | 
      | messageSchemaVersion      | 1.0                                  | 
      | messageSchemaName         | SytemInteraction                     | 
      | sourceApplicationName     | MuleESB-ORMS                   | 
      | targetDomainName          | com.asos.ip                          | 
      | flowID                    | bam-orms-locsv-006e                  | 
      | sourceDomainName          | com.asos.bam                         | 
  ##
  ##	Check if the Message In log was written to Azure
      And After at least 2 messages are read from the "${azurestorage.stage1.MessageQueueName}" and retrieve available messages
      And A log message was sent to the "${azurestorage.stage1.MessageQueueName}" which contains
      | messageSchemaVersion  | 1.0                    | 
      | entityID              | bam006                | 
      | messageSchemaName     | IntegrationMessage    | 
      | sourceApplicationName | MuleESB-ORMS     | 
      | flowId                | bam-orms-locsv-006e                | 
      | sourceDomainName      | com.asos.bam | 
  ##
  ##	Check if the Message Out log was written to Azure
      And A log message was sent to the "${azurestorage.stage1.MessageQueueName}" which contains
      | messageSchemaVersion  | 1.0                    | 
      | entityID              | bam006                | 
      | messageSchemaName     | IntegrationMessage    | 
      | sourceApplicationName | MuleESB-ORMS     | 
      | flowId                | bam-orms-locsv-006e                | 
      | sourceDomainName      | com.asos.bam | 
  ##
  ##	Check if the Flow steps log was written to Azure
  And After at least 6 messages are read from the "${azurestorage.stage1.FlowstepQueueName}" and retrieve available messages
      And A log message was sent to the "${azurestorage.stage1.FlowstepQueueName}" which contains
      | messageSchemaVersion | 1.0                 | 
      | entityID             | bam006              | 
      | flowStepId           | Start - End  | 
      | messageSchemaName    | IntegrationFlowStep | 
      | flowStepName         | Start               | 
      | flowID               | bam-orms-locsv-006e             | 
      
  
    Examples: 
      | InputPartitionKey   | InputFileName         | 
      | Stores__storecre    | storecre__9998.xml    |
       #| WH__whcre          | whcre__9.xml          | 