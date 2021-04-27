@localization
Feature: Check Localization mode

  @localization @local
  Scenario: Switch languages without log in
    When Open Atlas and Close Licence Agreement for any locale
    When Click to locale bar
    Then Available languages are shown
      | English |
      | Русский |
      | 한국어     |
      | 中文      |

  @localization @local
  Scenario: localization mode is disabled
    When Open Atlas and Close Licence Agreement for any locale
    Then Locale bar should not be visible