---
layout: default
title: Publish
nav_order: 3
has_children: true
---
{:.main-header-color-yellow}
# Publish
***
Publishes a message to one or more topics.

## Simple Examples   


|Command                                                |Explanation                                                              |
|-------------------------------------------------------|-------------------------------------------------------------------------|
| ``hivemq-cli pub -t test -m "Hello" `` | Publish the message "Hello" to the test topics with the default settings
| ``hivemq-cli pub -t test1 -t test2 -m "Hello Tests"`` | Publish the message "Hello Tests" on both test topics with the default settings
| ``hivemq-cli pub -t test -m "Hello" -h localhost -p 1884``| Publish the message "Hello" on localhost:1884|

See also 
```
hivemq-cli pub --help
```


*** 

## Synopsis

``` 
hivemq-cli pub {    -t <topic> [-t <topic>]...
                    -m <message>
                    [-q <qos>]...
                    [-r]
                    [-d]
                    [-v]
                    [-e <publishExpiryInterval>]
                    [-cd <correlationData>]
                    [-ct <contentType>]
                    [-pf <payloadFormatIndicator>]
                    [-pr <responseTopic>]
                    [-up <userProperties>]
                    [-h <host>]
                    [-p <port>]
                    [-V <version>]
                    [-i <identifier>]
                    [-ip <identifierPrefix>]
                    [-c]               
                    [-k <keepAlive>]
                    [-Ce <connectSessionExpiryInterval>]
                    [-Cup <connectUserProperties>]
                    [-s]
                    [-u <user>]
                    [-pw [<password>]]
                    [--cert <clientCertificate> --key <clientPrivateKey>]
                    [--cafile FILE]
                    [--capath DIR]...
                    [--ciphers <cipherSuites>[:<cipherSuites>...]]...
                    [--tls-version <supportedTLSVersions>]...
                    [-Wd <willDelayInterval>]
                    [-We <willMessageExpiryInterval>]
                    [-Wm <willMessage>]
                    [-Wq <willQos>]
                    [-Wr]
                    [-Wt <willTopic>]
                    [-Wcd <willCorrelationData>]
                    [-Wct <willContentType>]
                    [-Wpf <willPayloadFormatIndicator>]
                    [-Wrt <willResponseTopic>]
                    [-Wup <willUserProperties>]
                    [--rcvMax <receiveMaximum>]
                    [--sendMax <sendMaximum>]
                    [--maxPacketSize <maximumPacketSize>]
                    [--sendMaxPacketSize <sendMaximumPacketSize>]
                    [--sendTopicAliasMax <sendTopicAliasMaximum>]
                    [--topicAliasMax <topicAliasMaximum>]
                    [--[no-]reqProblemInfo]
                    [--[no-]reqResponseInfo]            
}
```

***

## Publish options

|Option   |Long Version    | Explanation                                         | Default|
|---------|----------------|-----------------------------------------------------|---------|
| ``-t``   | ``--topic``| The MQTT topic where the message will be published. |
| ``-m``| ``--message`` | The message which will be published on the topic. |
| ``-r``| ``--[no-]retain`` | Message will be retained. | ``False``
| ``-q`` | ``--qos`` | Use a defined quality of service level on all topics if only one QoS is specified.<br> You can define a specific QoS level for every topic. The corresponding QoS levels will be matched in order to the given topics. | ``0``
| ``-e`` | ``--publishExpiryInterval`` | The lifetime of the publish message in seconds. |
| ``-ct`` | ``--contentType`` | A description of the content of the publish message. |
| ``-cd`` | ``--correlationData`` | The correlation data of the publish message. |
| ``-pf`` | ``--payloadFormatIndicator`` | The payload format indicator of the publish message. |
| ``-rt`` | ``--responseTopic`` | The topic name for the response message of the publish message. |
| ``-up`` | ``--userProperties``  | The user property of the publish message. Usage: Key=Value, Key1=Value1:Key2=Value2 |
| ``-d``    |   ``--debug``     | Print debug level messages to the console. | ``False``
| ``-v``    |   ``--verbose``   | Print trace level messages to the console. | ``False``

***

## Connect Options

|Option   |Long Version    | Explanation                                         | Default|
|---------|----------------|-----------------------------------------------------|---------|
| ``-h``   | ``--host``| The MQTT host. | ``localhost``
| ``-p``  | ``--port``| The MQTT port. | ``1883``
| ``-V``   | ``--version``| The MQTT version can be set to 3 or 5. | ``MQTT  v.5.0``
| ``-i``   | ``--identifier`` | A unique client identifier can be defined. | A randomly defined UTF-8 String will be generated.
| ``-ip``  | ``--identifierPrefix``| The prefix identifier which will prepend the randomly generated client name if no identifier is given. | ``hmqClient``
| ``-c``   | ``--[no-]cleanStart`` | Enable clean start if set. | ``True``
| ``-Ce``  | ``--connectSessionExpiry`` | Session expiry value in seconds. | ``0`` (No Expiry)
| ``-Cup``  | ``--connectUserProperties`` | User properties of the connect message can be defined like <br> ``key=value`` for single pair or ``key1=value1\|key2=value2`` for multiple pairs. |

***

## Security Options

|Option   |Long Version    | Explanation                                         | Default|
|---------|----------------|-----------------------------------------------------|---------|
| ``-s``    | ``--secure``  | Use the default SSL configuration. | ``False``
| ``-u``   | ``--user`` | A username for authentication can be defined. |
| ``-pw``  | ``--password`` | A password for authentication can be defined directly. <br> If left blank the user will be prompted for the password in console. |
|   |   ``--cert``  |   The path to the client certificate to use for client-side authentication. |
|   |   ``--key``   |   The path to the client certificate corresponding  private key to use for client-side authentication.    |
|   | ``--cafile``    | Path to a file containing a trusted CA certificate to enable encrypted certificate based communication. |
|   | ``--capath``  | Path to a directory containing trusted CA certificates to enable encrypted certificate based communication. |
|   | ``--ciphers``  | The supported cipher suites in IANA string format concatenated by the ':' character if more than one cipher should be supported. <br> e.g ``TLS_CIPHER_1:TLS_CIPHER_2`` <br> See https://www.iana.org/assignments/tls-parameters/tls-parameters.xml for supported cipher suite strings. |
|   |   ``--tls-version``   |   The TLS version to use - ``TLSv1.1`` ``TLSv1.2`` ``TLSv1.3`` | ``TLSv1.2`` |

*** 

## Will Options

|Option   |Long Version    | Explanation                                         | Default|
|---------|----------------|-----------------------------------------------------|---------|
| ``-Wd`` | ``--willDelayInterval`` | Will delay interval in seconds. | ``0``
| ``-We``   | ``--willMessageExpiryInterval``   | Lifetime of the will message in seconds. <br> Can be disabled by setting it to ``4_294_967_295``| ``4_294_967_295`` (Disabled)
| ``-Wm``  | ``--willPayload`` | Payload of the will message. |
| ``-Wq``   | ``--willQualityOfService`` | QoS level of the will message. | ``0``
| ``-Wr``   | ``--[no-]willRetain``  | Retain the will message. | ``False``
| ``-Wt``  | ``--willTopic`` | Topic of the will message.  |
| ``-Wcd``  | ``--willCorrelationData`` | Correlation data of the will message  |
| ``-Wct``   | ``--willContentType`` |   Description of the will message's content. |
| ``-Wpf``  | ``--willPayloadFormatIndicator`` |Payload format can be explicitly specified as ``UTF8`` else it may be ``UNSPECIFIED``. |
| ``-Wrt``  | ``--willResponseTopic`` | Topic Name for a response message.   |
| ``-Wup``   | ``--willUserProperties``  | User properties of the will message can be defined like <br> ``key=value`` for single pair or ``key1=value1\|key2=value2`` for multiple pairs. |

*** 

## Connect Restrictions

|Option   |Long Version    | Explanation                                         | Default|
|---------|----------------|-----------------------------------------------------|---------|
|   |  ``--rcvMax``  |  The maximum amount of not acknowledged publishes with QoS 1 or 2 the client accepts from the server concurrently.  | ``65535``
|   |  ``--sendMax`` |  The maximum amount of not acknowledged publishes with QoS 1 or 2 the client send to the server concurrently.  | ``65535``
|   |  ``--maxPacketSize`` | The maximum packet size the client accepts from the server. | ``268435460``
|   | ``--sendMaxPacketSize`` |  The maximum packet size the client sends to the server. | ``268435460``
|   |  ``--topicAliasMax``  |  The maximum amount of topic aliases the client accepts from the server.  | ``0``
|   |  ``--sendTopicAliasMax``  |  The maximum amount of topic aliases the client sends to the server.  | ``16``
|   |  `` --[no-]reqProblemInfo`` |  The client requests problem information from the server.  | ``true``
|   |  ``--[no-]reqResponseInfo``  | The client requests response information from the server. | ``false``

*** 

## Further Examples

> Publish a message with default QoS set to ``Exactly Once``

> **NOTE**: If you only specify one QoS but more than one topic the QoS will be used as default QoS for all topics.

```
$ hivemq-cli pub -t topic1 -t topic2 -q 2
```

> Publish a message with a given QoS for each topic. (topic1 will have QoS 0, topic2 QoS 1, topic2 QoS 2)

```
$ hivemq-cli pub -t topic1 -t topic2 -t topic3 -q 0 -q 1 -q 2
```