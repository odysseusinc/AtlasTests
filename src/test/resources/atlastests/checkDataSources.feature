#@datasources
  @ds
Feature: Check Data Sources reports

  ############################################################################################################
  #IMPALA#
  #############################################################################################################
@impala
  Scenario: Impala Source & Dashboard
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "IMPALA"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page

  @impala
  Scenario: IMPALA Source & Data Density
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "IMPALA"
    When choose Report from Data Source as "Data Density"
    Then can see Data Density windows

  @impala
  Scenario: IMPALA Source & Person
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "IMPALA"
    When choose Report from Data Source as "Person"
    Then can see Person windows

  @impala
  Scenario: IMPALA Source & Visit
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "IMPALA"
    When choose Report from Data Source as "Visit"
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell


  @impala
  Scenario: IMPALA Source & Condition
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "IMPALA"
    When choose Report from Data Source as "Condition Occurrence"
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell

  @impala
  Scenario: IMPALA Source & Condition Era
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "IMPALA"
    When choose Report from Data Source as "Condition Era"
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell

  @impala
  Scenario: IMPALA Source & Procedure
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "IMPALA"
    When choose Report from Data Source as "Procedure"
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell

  @impala
  Scenario: IMPALA Source & Drug Exposure
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "IMPALA"
    When choose Report from Data Source as "Drug Exposure"
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell

  @impala
  Scenario: IMPALA Source & Drug Era
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "IMPALA"
    When choose Report from Data Source as "Drug Era"
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell


  @impala
  Scenario: IMPALA Source & Measurement
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "IMPALA"
    When choose Report from Data Source as "Measurement"
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell


  @impala
  Scenario: IMPALA Source & Observation
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "IMPALA"
    When choose Report from Data Source as "Observation"
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell

  @impala
  Scenario: IMPALA Source & Death
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "IMPALA"
    When choose Report from Data Source as "Death"
    Then can see Death windows

  @impala
  Scenario: IMPALA Source & Achilles Heel
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "IMPALA"
    When choose Report from Data Source as "Achilles Heel"
    Then can see Achilles Heel windows

 ############################################################################################################
  #Netezza CDM5.3#
  #############################################################################################################
@netezza
  Scenario: Netezza CDM5.3 Source & Dashboard
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "Netezza CDM5.3"
    When choose Report from Data Source as "Dashboard"
    Then can see dashboard
    Then can see windows in DASHBOARD page

  @netezza
  Scenario: Netezza CDM5.3 Source & Data Density
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "Netezza CDM5.3"
    When choose Report from Data Source as "Data Density"
    Then can see Data Density windows

  @netezza
  Scenario: Netezza CDM5.3 Source & Person
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "Netezza CDM5.3"
    When choose Report from Data Source as "Person"
    Then can see Person windows

  @netezza
  Scenario: Netezza CDM5.3 Source & Visit
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "Netezza CDM5.3"
    When choose Report from Data Source as "Visit"
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell


  @netezza
  Scenario: Netezza CDM5.3 Source & Condition
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "Netezza CDM5.3"
    When choose Report from Data Source as "Condition Occurrence"
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell

  @netezza
  Scenario: Netezza CDM5.3 Source & Condition Era
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "Netezza CDM5.3"
    When choose Report from Data Source as "Condition Era"
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell


  @netezza
  Scenario: Netezza CDM5.3 Source & Procedure
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "Netezza CDM5.3"
    When choose Report from Data Source as "Procedure"
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell

  @netezza
  Scenario: Netezza CDM5.3 Source & Drug Exposure
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "Netezza CDM5.3"
    When choose Report from Data Source as "Drug Exposure"
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell

  @netezza
  Scenario: Netezza CDM5.3 Source & Drug Era
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "Netezza CDM5.3"
    When choose Report from Data Source as "Drug Era"
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell


  @netezza
  Scenario: Netezza CDM5.3 Source & Measurement
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "Netezza CDM5.3"
    When choose Report from Data Source as "Measurement"
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell


  @netezza
  Scenario: Netezza CDM5.3 Source & Observation
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "Netezza CDM5.3"
    When choose Report from Data Source as "Observation"
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell

  @netezza
  Scenario: Netezza CDM5.3 Source & Death
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "Netezza CDM5.3"
    When choose Report from Data Source as "Death"
    Then can see Death windows

  @netezza
  Scenario: Netezza CDM5.3 Source & Achilles Heel
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "Netezza CDM5.3"
    When choose Report from Data Source as "Achilles Heel"
    Then can see Achilles Heel windows


  ############################################################################################################
  #OVH02 SynPUF 110k#
  #############################################################################################################

  @ovh02
  Scenario: OVH02 SynPUF 110k Source & Dashboard
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OVH02 SynPUF 110k"
    When choose Report from Data Source as "Dashboard"
    Then can see dashboard
    Then can see windows in DASHBOARD page

  @ovh02
  Scenario: OVH02 SynPUF 110k Source & Data Density
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OVH02 SynPUF 110k"
    When choose Report from Data Source as "Data Density"
    Then can see Data Density windows

  @ovh02
  Scenario: OVH02 SynPUF 110k Source & Person
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OVH02 SynPUF 110k"
    When choose Report from Data Source as "Person"
    Then can see Person windows

  @ovh02
  Scenario: OVH02 SynPUF 110k Source & Visit
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OVH02 SynPUF 110k"
    When choose Report from Data Source as "Visit"
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell

  @ovh02
  Scenario: OVH02 SynPUF 110k Source & Condition
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OVH02 SynPUF 110k"
    When choose Report from Data Source as "Condition Occurrence"
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell

  @ovh02
  Scenario: OVH02 SynPUF 110k Source & Condition Era
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OVH02 SynPUF 110k"
    When choose Report from Data Source as "Condition Era"
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell

  @ovh02
  Scenario: OVH02 SynPUF 110k Source & Procedure
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OVH02 SynPUF 110k"
    When choose Report from Data Source as "Procedure"
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell

  @ovh02
  Scenario: OVH02 SynPUF 110k Source & Drug Exposure
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OVH02 SynPUF 110k"
    When choose Report from Data Source as "Drug Exposure"
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell

  @ovh02
  Scenario: OVH02 SynPUF 110k Source & Drug Era
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OVH02 SynPUF 110k"
    When choose Report from Data Source as "Drug Era"
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell


  @ovh02
  Scenario: OVH02 SynPUF 110k Source & Measurement
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OVH02 SynPUF 110k"
    When choose Report from Data Source as "Measurement"
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell

  @ovh02
  Scenario: OVH02 SynPUF 110k Source & Observation
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OVH02 SynPUF 110k"
    When choose Report from Data Source as "Observation"
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell

  @ovh02
  Scenario: OVH02 SynPUF 110k Source & Death
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OVH02 SynPUF 110k"
    When choose Report from Data Source as "Death"
    Then can see Death windows

  @ovh02
  Scenario: OVH02 SynPUF 110k Source & Achilles Heel
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OVH02 SynPUF 110k"
    When choose Report from Data Source as "Achilles Heel"
    Then can see Achilles Heel windows

  #############################################################################################################
  #SynPUF110K COST & UTIL#
  #############################################################################################################

  @SynPUF110KCost
  Scenario: SynPUF110KCost&Util Source & Dashboard
   When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K Cost&Util"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page


  @SynPUF110KCost
  Scenario: SynPUF110KCost&Util Source & Data Density
   When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K Cost&Util"
    When choose Report from Data Source as "Data Density"
    Then can see Data Density windows

  @SynPUF110KCost
  Scenario: SynPUF110KCost&Util Source & Person
   When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K Cost&Util"
    When choose Report from Data Source as "Person"
    Then can see Person windows

  @SynPUF110KCost
  Scenario: SynPUF110KCost&Util Source & Visit
   When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K Cost&Util"
    When choose Report from Data Source as "Visit"
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell


  @SynPUF110KCost
  Scenario: SynPUF110KCost&Util Source & Condition
   When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K Cost&Util"
    When choose Report from Data Source as "Condition Occurrence"
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell

  @SynPUF110KCost
  Scenario: SynPUF110KCost&Util Source & Condition Era
   When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K Cost&Util"
    When choose Report from Data Source as "Condition Era"
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell

  @SynPUF110KCost
  Scenario: SynPUF110KCost&Util Source & Procedure
   When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K Cost&Util"
    When choose Report from Data Source as "Procedure"
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell

  @SynPUF110KCost
  Scenario: SynPUF110KCost&Util Source & Drug Exposure
   When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K Cost&Util"
    When choose Report from Data Source as "Drug Exposure"
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell

  @SynPUF110KCost
  Scenario: SynPUF110KCost&Util Source & Drug Era
   When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K Cost&Util"
    When choose Report from Data Source as "Drug Era"
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell


  @SynPUF110KCost
  Scenario: SynPUF110KCost&Util Source & Measurement
   When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K Cost&Util"
    When choose Report from Data Source as "Measurement"
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell


  @SynPUF110KCost
  Scenario: SynPUF110KCost&Util Source & Observation
   When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K Cost&Util"
    When choose Report from Data Source as "Observation"
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell

  @SynPUF110KCost
  Scenario: SynPUF110KCost&Util Source & Death
   When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K Cost&Util"
    When choose Report from Data Source as "Death"
    Then can see Death windows

  @SynPUF110KCost
  Scenario: SynPUF110KCost&Util Source & Achilles Heel
   When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K Cost&Util"
    When choose Report from Data Source as "Achilles Heel"
    Then can see Achilles Heel windows

  #############################################################################################################
  #SynPUF110K CDM5.3#
  #############################################################################################################

  @SynPUF110Kcdm
  Scenario: SynPUF 110k CDM5.3 Source & Dashboard
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110k CDM5.3"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page

  @SynPUF110Kcdm
  Scenario: SynPUF 110k CDM5.3 Source & Data Density
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110k CDM5.3"
    When choose Report from Data Source as "Data Density"
    Then can see Data Density windows

  @SynPUF110Kcdm
  Scenario: SynPUF 110k CDM5.3 Source & Person
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110k CDM5.3"
    When choose Report from Data Source as "Person"
    Then can see Person windows

  @SynPUF110Kcdm
  Scenario: SynPUF 110k CDM5.3 Source & Visit
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110k CDM5.3"
    When choose Report from Data Source as "Visit"
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell


  @SynPUF110Kcdm
  Scenario: SynPUF 110k CDM5.3 Source & Condition
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110k CDM5.3"
    When choose Report from Data Source as "Condition Occurrence"
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell

  @SynPUF110Kcdm
  Scenario: SynPUF 110k CDM5.3 Source & Condition Era
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110k CDM5.3"
    When choose Report from Data Source as "Condition Era"
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell

  @SynPUF110Kcdm
  Scenario: SynPUF 110k CDM5.3 Source & Procedure
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110k CDM5.3"
    When choose Report from Data Source as "Procedure"
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell

  @SynPUF110Kcdm
  Scenario: SynPUF 110k CDM5.3 Source & Drug Exposure
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110k CDM5.3"
    When choose Report from Data Source as "Drug Exposure"
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell

  @SynPUF110Kcdm
  Scenario: SynPUF 110k CDM5.3 Source & Drug Era
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110k CDM5.3"
    When choose Report from Data Source as "Drug Era"
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell


  @SynPUF110Kcdm
  Scenario: SynPUF 110k CDM5.3 Source & Measurement
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110k CDM5.3"
    When choose Report from Data Source as "Measurement"
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell


  @SynPUF110Kcdm
  Scenario: SynPUF 110k CDM5.3 Source & Observation
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110k CDM5.3"
    When choose Report from Data Source as "Observation"
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell

  @SynPUF110Kcdm
  Scenario: SynPUF 110k CDM5.3 Source & Death
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110k CDM5.3"
    When choose Report from Data Source as "Death"
    Then can see Death windows

  @SynPUF110Kcdm
  Scenario: SynPUF 110k CDM5.3 Source & Achilles Heel
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110k CDM5.3"
    When choose Report from Data Source as "Achilles Heel"
    Then can see Achilles Heel windows


  #############################################################################################################
  #SynPUF 2.3m (GCP BigQuery)#
  #############################################################################################################

  @synPUF23m
  Scenario: SynPUF110K 2.3m (GCP BigQuery) Source & Dashboard
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2.3m (GCP BigQuery)"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page

  @synPUF23m
  Scenario: SynPUF110K 2.3m (GCP BigQuery) Source & Data Density
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2.3m (GCP BigQuery)"
    When choose Report from Data Source as "Data Density"
    Then can see Data Density windows

  @synPUF23m
  Scenario: SynPUF110K 2.3m (GCP BigQuery) Source & Person
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2.3m (GCP BigQuery)"
    When choose Report from Data Source as "Person"
    Then can see Person windows

  @synPUF23m
  Scenario: SynPUF110K 2.3m (GCP BigQuery) Source & Visit
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2.3m (GCP BigQuery)"
    When choose Report from Data Source as "Visit"
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell

  @synPUF23m
  Scenario: SynPUF110K 2.3m (GCP BigQuery) Source & Condition
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2.3m (GCP BigQuery)"
    When choose Report from Data Source as "Condition Occurrence"
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell

  @synPUF23m
  Scenario: SynPUF110K 2.3m (GCP BigQuery) Source & Condition Era
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2.3m (GCP BigQuery)"
    When choose Report from Data Source as "Condition Era"
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell

  @synPUF23m
  Scenario: SynPUF110K 2.3m (GCP BigQuery) Source & Procedure
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2.3m (GCP BigQuery)"
    When choose Report from Data Source as "Procedure"
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell

  @synPUF23m
  Scenario: SynPUF110K 2.3m (GCP BigQuery) Source & Drug Exposure
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2.3m (GCP BigQuery)"
    When choose Report from Data Source as "Drug Exposure"
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell

  @synPUF23m
  Scenario: SynPUF110K 2.3m (GCP BigQuery) Source & Drug Era
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2.3m (GCP BigQuery)"
    When choose Report from Data Source as "Drug Era"
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell


  @synPUF23m
  Scenario: SynPUF110K 2.3m (GCP BigQuery) Source & Measurement
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2.3m (GCP BigQuery)"
    When choose Report from Data Source as "Measurement"
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell


  @synPUF23m
  Scenario: SynPUF110K 2.3m (GCP BigQuery) Source & Observation
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2.3m (GCP BigQuery)"
    When choose Report from Data Source as "Observation"
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell

  @synPUF23m
  Scenario: SynPUF110K 2.3m (GCP BigQuery) Source & Death
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2.3m (GCP BigQuery)"
    When choose Report from Data Source as "Death"
    Then can see Death windows

  @synPUF23m
  Scenario: SynPUF110K 2.3m (GCP BigQuery) Source & Achilles Heel
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2.3m (GCP BigQuery)"
    When choose Report from Data Source as "Achilles Heel"
    Then can see Achilles Heel windows


  #############################################################################################################
  #SynPUF 2M CDM5.3#
  #############################################################################################################

  @synPUF2mcdm
  Scenario: SynPUF 2M CDM5.3 Source & Dashboard
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2M CDM5.3"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page

  @synPUF2mcdm
  Scenario: SynPUF 2M CDM5.3 Source & Data Density
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2M CDM5.3"
    When choose Report from Data Source as "Data Density"
    Then can see Data Density windows

  @synPUF2mcdm
  Scenario: SynPUF 2M CDM5.3 Source & Person
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2M CDM5.3"
    When choose Report from Data Source as "Person"
    Then can see Person windows

  @synPUF2mcdm
  Scenario: SynPUF 2M CDM5.3 Source & Visit
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2M CDM5.3"
    When choose Report from Data Source as "Visit"
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell

  @synPUF2mcdm
  Scenario: SynPUF 2M CDM5.3 Source & Condition
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2M CDM5.3"
    When choose Report from Data Source as "Condition Occurrence"
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell

  @synPUF2mcdm
  Scenario: SynPUF 2M CDM5.3 Source & Condition Era
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2M CDM5.3"
    When choose Report from Data Source as "Condition Era"
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell

  @synPUF2mcdm
  Scenario: SynPUF 2M CDM5.3 Source & Procedure
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2M CDM5.3"
    When choose Report from Data Source as "Procedure"
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell

  @synPUF2mcdm
  Scenario: SynPUF 2M CDM5.3 Source & Drug Exposure
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2M CDM5.3"
    When choose Report from Data Source as "Drug Exposure"
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell

  @synPUF2mcdm
  Scenario: SynPUF 2M CDM5.3 Source & Drug Era
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2M CDM5.3"
    When choose Report from Data Source as "Drug Era"
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell


  @synPUF2mcdm
  Scenario: SynPUF 2M CDM5.3 Source & Measurement
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2M CDM5.3"
    When choose Report from Data Source as "Measurement"
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell


  @synPUF2mcdm
  Scenario: SynPUF 2M CDM5.3 Source & Observation
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2M CDM5.3"
    When choose Report from Data Source as "Observation"
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell

  @synPUF2mcdm
  Scenario: SynPUF 2M CDM5.3 Source & Death
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2M CDM5.3"
    When choose Report from Data Source as "Death"
    Then can see Death windows

  @synPUF2mcdm
  Scenario: SynPUF 2M CDM5.3 Source & Achilles Heel
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2M CDM5.3"
    When choose Report from Data Source as "Achilles Heel"
    Then can see Achilles Heel windows


  #############################################################################################################
  #oracle-110k#
  #############################################################################################################

  @oracle110k
  Scenario: oracle-110k Source & Dashboard
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "oracle-110k"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page

  @oracle110k
  Scenario: oracle-110k Source & Data Density
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "oracle-110k"
    When choose Report from Data Source as "Data Density"
    Then can see Data Density windows

  @oracle110k
  Scenario: oracle-110k Source & Person
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "oracle-110k"
    When choose Report from Data Source as "Person"
    Then can see Person windows

  @oracle110k
  Scenario: oracle-110k Source & Visit
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "oracle-110k"
    When choose Report from Data Source as "Visit"
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell

  @oracle110k
  Scenario: oracle-110k Source & Condition
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "oracle-110k"
    When choose Report from Data Source as "Condition Occurrence"
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell

  @oracle110k
  Scenario: oracle-110k Source & Condition Era
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "oracle-110k"
    When choose Report from Data Source as "Condition Era"
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell


  @oracle110k
  Scenario: oracle-110k Source & Procedure
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "oracle-110k"
    When choose Report from Data Source as "Procedure"
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell

  @oracle110k
  Scenario: oracle-110k Source & Drug Exposure
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "oracle-110k"
    When choose Report from Data Source as "Drug Exposure"
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell

  @oracle110k
  Scenario: oracle-110k Source & Drug Era
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "oracle-110k"
    When choose Report from Data Source as "Drug Era"
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell


  @oracle110k
  Scenario: oracle-110k Source & Measurement
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "oracle-110k"
    When choose Report from Data Source as "Measurement"
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell


  @oracle110k
  Scenario: oracle-110k Source & Observation
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "oracle-110k"
    When choose Report from Data Source as "Observation"
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell

  @oracle110k
  Scenario: oracle-110k Source & Death
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "oracle-110k"
    When choose Report from Data Source as "Death"
    Then can see Death windows

  @oracle110k
  Scenario: oracle-110k Source & Achilles Heel
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "oracle-110k"
    When choose Report from Data Source as "Achilles Heel"
    Then can see Achilles Heel windows



