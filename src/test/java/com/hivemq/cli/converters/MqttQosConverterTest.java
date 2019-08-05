package com.hivemq.cli.converters;

import com.hivemq.client.mqtt.datatypes.MqttQos;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MqttQosConverterTest {

    private MqttQosConverter mqttQosConverter;

    @BeforeEach
    void setUp() {
        mqttQosConverter = new MqttQosConverter();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "AT_MOST_ONCE", "at_most_once"})
    void testAtMostOnceSuccess(final @NotNull String s) throws Exception {
        MqttQos expected = MqttQos.AT_MOST_ONCE;
        assertEquals(expected, mqttQosConverter.convert(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "AT_LEAST_ONCE", "at_least_once"})
    void testAtLeastOnceSuccess(final @NotNull String s) throws Exception {
        MqttQos expected = MqttQos.AT_LEAST_ONCE;
        assertEquals(expected, mqttQosConverter.convert(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "EXACTLY_ONCE", "exactly_once"})
    void testExactlyOnceSuccess(final @NotNull String s) throws Exception {
        MqttQos expected = MqttQos.EXACTLY_ONCE;
        assertEquals(expected, mqttQosConverter.convert(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "3", "test"})
    void testFailureInputs(final @NotNull String s) {
        Exception e = assertThrows(Exception.class, () -> mqttQosConverter.convert(s));
        assertEquals(MqttQosConverter.WRONG_INPUT_MESSAGE, e.getMessage());
    }
}