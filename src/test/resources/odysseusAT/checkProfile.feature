Feature: check Profile

  Scenario: choose profile of Impala
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "Impala" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table

  Scenario: choose profile of Netezza53
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "Netezza53" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table

  Scenario: choose profile of OVH02_110K
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "OVH02_110K" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table


  Scenario: choose profile of synpuf_110k_cu
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "synpuf_110k_cu" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table

  Scenario: choose profile of synpuf_110k_bigquery
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "synpuf_110k_bigquery" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table

  Scenario: choose profile of synpuf_2m_bigquery
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "synpuf_2m_bigquery" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table

  Scenario: choose profile of SYNPUF_2M
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "SYNPUF_2M" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table

  Scenario: choose profile of oracle-110k
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "oracle-110k" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table