package com.hu.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class NumberUtilsTest {

  @Test
  public void should_return_true_new_numberUtils() {
    //given
    //when
    //then
    assertThat(new NumberUtils()).isInstanceOf(NumberUtils.class);
  }

  @Test
  public void should_return_false_when_str_is_null() {
    //given
    //when
    //then
    assertThat(NumberUtils.isCreatable(null)).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_blank() {
    //given
    //when
    //then
    assertThat(NumberUtils.isCreatable("")).isEqualTo(false);
  }

  @Test
  public void should_return_true_when_str_is_hexadecimal_marked_with_0x_qualifier() {
    //given
    String str = "0x123";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_true_when_str_is_hexadecimal_marked_with_0X_qualifier() {
    //given
    String str = "0X123";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_false_when_str_is_not_hexadecimal_marked_with_0x_qualifier() {
    //given
    String str = "0xGH";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_not_hexadecimal_marked_with_0X_qualifier() {
    //given
    String str = "0xGH";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_true_when_str_is_sign_up_plus() {
    //given
    String str = "+123";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_true_when_str_is_sign_up_minus() {
    //given
    String str = "-123";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_false_when_str_is_less_than_a() {
    //given
    String str = "0X.";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_less_than_A() {
    //given
    String str = "0X@";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_less_than_0() {
    //given
    String str = "0X/";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_more_than_9() {
    //given
    String str = "0X:";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_more_than_f() {
    //given
    String str = "0Xg";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_more_than_F() {
    //given
    String str = "0XG";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_0x() {
    //given
    String str = "0x";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
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
  public void should_return_false_when_str_is_Non_hexadecimal_beginning_with_a_leading_zero_less_than_0() {
    //given
    String str = "0/";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }


  @Test
  public void should_return_false_when_str_is_Non_hexadecimal_beginning_with_a_leading_zero_more_than_7() {
    //given
    String str = "08";
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
  public void should_return_false_when_str_is_contains_point_exp() {
    //given
    String str = "501E2.5";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
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
  public void should_return_false_when_str_is_minus_not_after_e() {
    //given
    String str = "12e2-12";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_plus_e_e() {
    //given
    String str = "-12e";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_true_when_str_is_minus_after_e() {
    //given
    String str = "12e-12";
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
  public void should_return_false_when_str_is_not_end_with_e() {
    //given
    String str = "123e";
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
  public void should_return_false_when_str_is_marked_with_a_type_qualifier_and_has_point_epx() {
    //given
    String str = "12E3.";
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
  public void should_return_true_when_str_is_marked_with_a_type_qualifier_and_end_with_d() {
    //given
    String str = "12d";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_true_when_str_is_marked_with_a_type_qualifier_and_end_with_D() {
    //given
    String str = "12D";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_true_when_str_is_marked_with_a_type_qualifier_and_end_with_f() {
    //given
    String str = "1.2f";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_true_when_str_is_marked_with_a_type_qualifier_and_end_with_F() {
    //given
    String str = "12F";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_true_when_str_is_marked_with_a_type_qualifier_and_end_with_L() {
    //given
    String str = "12L";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }

  @Test
  public void should_return_true_when_str_is_marked_with_a_type_qualifier_and_end_with_l() {
    //given
    String str = "12l";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(true);
  }


  @Test
  public void should_return_false_when_str_is_marked_with_a_type_qualifier_and_end_with_point_L() {
    //given
    String str = "1.2L";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_marked_with_a_type_qualifier_and_end_with_exp_l() {
    //given
    String str = "1E2L";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
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
  public void should_return_false_when_str_is_plus() {
    //given
    String str = "+";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }

  @Test
  public void should_return_false_when_str_is_minus() {
    //given
    String str = "1-";
    //when
    boolean result = NumberUtils.isCreatable(str);
    //then
    assertThat(result).isEqualTo(false);
  }
}
