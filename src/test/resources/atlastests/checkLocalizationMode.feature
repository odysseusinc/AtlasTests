@localization
Feature: Check Localization mode

  @local
  Scenario: Switch languages without log in
    When Open Atlas and Close Licence Agreement for any locale
    When Click to locale bar
    Then Available languages are shown
      | English |
      | Русский |
      | 한국어     |
      | 中文      |