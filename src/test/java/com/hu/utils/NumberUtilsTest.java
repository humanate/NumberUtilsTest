package com.hu.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class NumberUtilsTest {

  @Test
  public void should_return_false_when_str_is_null() {
    //given
    //when
    //then
    assertThat(NumberUtils.isCreatable(null)).isEqualTo(false);
    assertThat(NumberUtils.isCreatable("")).isEqualTo(false);
  }

  @Test
  public void should_return_true_when_str_is_hexadecimal_marked_with_0x_or_0X_qualifier() {
    //given
    String str_0x = "0x123";
    String str_0X = "0X123";
    //when
    boolean result_0X = NumberUtils.isCreatable(str_0X);
    boolean result_0x = NumberUtils.isCreatable(str_0x);
    //then
    assertThat(result_0X).isEqualTo(true);
    assertThat(result_0x).isEqualTo(true);
  }

  @Test
  public void should_return_false_when_str_is_not_hexadecimal_marked_with_0x_or_0X_qualifier() {
    //given
    String str_0X = "0xGH";
    String str_0x = "0xHU";
    //when
    boolean result_0X = NumberUtils.isCreatable(str_0X);
    boolean result_0x = NumberUtils.isCreatable(str_0x);
    //then
    assertThat(result_0x).isEqualTo(false);
    assertThat(result_0X).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_0x() {
    //given
    String str = "0x";
    //when
    boolean result_0x = NumberUtils.isCreatable(str);
    //then
    assertThat(result_0x).isEqualTo(false);
  }

  @Test
  public void should_return_true_when_str_is_octal_numbers() {
    //given
    String str = "07";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_false_when_str_is_Non_hexadecimal_beginning_with_a_leading_zero() {
    //given
    String str = "09";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_true_when_str_is_scientific_notation() {
    //given
    String str = "50123.12E25";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_false_when_str_is_contains_two_point() {
    //given
    String str = "501.2.5";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_contains_two_E() {
    //given
    String str = "50E12E3";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_not_contains_digit() {
    //given
    String str = "ABC";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_not_contains_digit_and_contains_e() {
    //given
    String str = "EA";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_plus_not_after_e() {
    //given
    String str = "12e2+12";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_true_when_str_is_plus_after_e() {
    //given
    String str = "12e+12";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_true_when_str_is_marked_with_a_type_qualifier() {
    //given
    String str = "123L";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_false_when_str_is_not_end_with_E() {
    //given
    String str = "123E";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }
  @Test
  public void should_return_false_when_str_is_marked_with_a_type_qualifier_and_has_two_point() {
    //given
    String str = "12.3.";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_true_when_str_is_marked_with_a_type_qualifier_and_end_with_point() {
    //given
    String str = "12.";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_true_when_str_is_marked_with_a_type_qualifier_and_front_is_digit() {
    //given
    String str = "12d";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_false_when_str_is_last_character_is_illegal() {
    //given
    String str = "12X";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_end_with_e() {
    //given
    String str = "123E+E";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }
}
