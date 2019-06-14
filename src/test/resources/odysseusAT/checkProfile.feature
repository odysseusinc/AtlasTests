@profiles
Feature: check Profile

  @dev140619
  Scenario: choose profile of Impala
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "IMPALA" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table

  Scenario: choose profile of Netezza53
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "Netezza CDM5.3" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table

  Scenario: choose profile of OVH02_110K
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "OVH02 SynPUF 110k" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table


  Scenario: choose profile of synpuf_110k_cu
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "SynPUF 110K Cost&Util" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table

  @aa
  Scenario: choose profile of synpuf_110k_bigquery
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "SynPUF 110k (GCP BigQuery)" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table

  Scenario: choose profile of synpuf_110k_cdm53
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "SynPUF 110k CDM5.3" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table


  Scenario: choose profile of synpuf_2m_bigquery
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "SynPUF 2.3m (GCP BigQuery)" in Profile Source
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table

  Scenario: choose profile of SYNPUF_2M
    When login to ATLAS as QA
    When click to Profiles menu as QA
    Then can see Profiles page
    When click to Select a Data Source
    When choose "SynPUF 2M CDM5.3" in Profile Source
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