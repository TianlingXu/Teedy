package com.sismics.util;

import jakarta.json.JsonValue;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for {@link JsonUtil}.
 * 
 * @author Test Author
 */
public class TestJsonUtil {

    /**
     * Test nullable(String) with null value.
     * Covers the null branch.
     */
    @Test
    public void testNullableStringNull() {
        JsonValue result = JsonUtil.nullable((String) null);
        assertNotNull(result);
        assertEquals(JsonValue.ValueType.NULL, result.getValueType());
    }

    /**
     * Test nullable(String) with non-null value.
     * Covers the non-null branch.
     */
    @Test
    public void testNullableStringNonNull() {
        String testValue = "test string";
        JsonValue result = JsonUtil.nullable(testValue);
        assertNotNull(result);
        assertEquals(JsonValue.ValueType.STRING, result.getValueType());
        assertEquals(testValue, result.toString().replace("\"", ""));
    }

    /**
     * Test nullable(Integer) with null value.
     * Covers the null branch.
     */
    @Test
    public void testNullableIntegerNull() {
        JsonValue result = JsonUtil.nullable((Integer) null);
        assertNotNull(result);
        assertEquals(JsonValue.ValueType.NULL, result.getValueType());
    }

    /**
     * Test nullable(Integer) with non-null value.
     * Covers the non-null branch.
     */
    @Test
    public void testNullableIntegerNonNull() {
        Integer testValue = 42;
        JsonValue result = JsonUtil.nullable(testValue);
        assertNotNull(result);
        assertEquals(JsonValue.ValueType.NUMBER, result.getValueType());
    }

    /**
     * Test nullable(Long) with null value.
     * Covers the null branch.
     */
    @Test
    public void testNullableLongNull() {
        JsonValue result = JsonUtil.nullable((Long) null);
        assertNotNull(result);
        assertEquals(JsonValue.ValueType.NULL, result.getValueType());
    }

    /**
     * Test nullable(Long) with non-null value.
     * Covers the non-null branch.
     */
    @Test
    public void testNullableLongNonNull() {
        Long testValue = 123456789L;
        JsonValue result = JsonUtil.nullable(testValue);
        assertNotNull(result);
        assertEquals(JsonValue.ValueType.NUMBER, result.getValueType());
    }

    /**
     * Test nullable(String) with empty string.
     * Edge case for non-null branch.
     */
    @Test
    public void testNullableStringEmpty() {
        String testValue = "";
        JsonValue result = JsonUtil.nullable(testValue);
        assertNotNull(result);
        assertEquals(JsonValue.ValueType.STRING, result.getValueType());
    }

    /**
     * Test nullable(Integer) with zero.
     * Edge case for non-null branch.
     */
    @Test
    public void testNullableIntegerZero() {
        Integer testValue = 0;
        JsonValue result = JsonUtil.nullable(testValue);
        assertNotNull(result);
        assertEquals(JsonValue.ValueType.NUMBER, result.getValueType());
    }

    /**
     * Test nullable(Long) with zero.
     * Edge case for non-null branch.
     */
    @Test
    public void testNullableLongZero() {
        Long testValue = 0L;
        JsonValue result = JsonUtil.nullable(testValue);
        assertNotNull(result);
        assertEquals(JsonValue.ValueType.NUMBER, result.getValueType());
    }
}
