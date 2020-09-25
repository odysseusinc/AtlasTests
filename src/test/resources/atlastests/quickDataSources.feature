#@qt_devv
  @qds
Feature: Quick test Data Source
  ##################################################################
    # Quick tests                                                    #
    ##################################################################
  @qt_ds @eunomiaqt @ohdsi
  Scenario: Quick test Eunomia data source
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OHDSI Eunomia CDM V5 Database"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Report from Data Source as "Data Density"
    Then can see Data Density windows
    When choose Report from Data Source as "Person"
    Then can see Person windows
    When choose Report from Data Source as "Visit"
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell
    When choose Report from Data Source as "Condition Occurrence"
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell
    When choose Report from Data Source as "Condition Era"
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell
    When choose Report from Data Source as "Procedure"
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell
    When choose Report from Data Source as "Drug Exposure"
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell
    When choose Report from Data Source as "Drug Era"
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell
    When choose Report from Data Source as "Measurement"
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell
    When choose Report from Data Source as "Observation"
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell
    When choose Report from Data Source as "Death"
    Then can see Death windows
    When choose Report from Data Source as "Achilles Heel"
    Then can see Achilles Heel windows


  @qt_dev @odysseus
  Scenario: Quick Test Impala
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "IMPALA"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Report from Data Source as "Data Density"
    Then can see preloader in Data Source
    Then can see Data Density windows
    When choose Report from Data Source as "Person"
    Then can see preloader in Data Source
    Then can see Person windows
    When choose Report from Data Source as "Visit"
    Then can see preloader in Data Source
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell
    When choose Report from Data Source as "Condition Occurrence"
    Then can see preloader in Data Source
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell
    When choose Report from Data Source as "Condition Era"
    Then can see preloader in Data Source
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell
    When choose Report from Data Source as "Procedure"
    Then can see preloader in Data Source
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell
    When choose Report from Data Source as "Drug Exposure"
    Then can see preloader in Data Source
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell
    When choose Report from Data Source as "Drug Era"
    Then can see preloader in Data Source
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell
    When choose Report from Data Source as "Measurement"
    Then can see preloader in Data Source
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell
    When choose Report from Data Source as "Observation"
    Then can see preloader in Data Source
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell
    When choose Report from Data Source as "Death"
    Then can see preloader in Data Source
    Then can see Death windows
    When choose Report from Data Source as "Achilles Heel"
    Then can see preloader in Data Source
    Then can see Achilles Heel windows

  @qt_ds @qt_netezza @odysseus
  Scenario: Quick test Netezza CDM5.3
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "Netezza CDM5.3"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page
    When Data Source Page opened
    When choose Report from Data Source as "Data Density"
    Then can see preloader in Data Source
    Then can see Data Density windows
    When choose Report from Data Source as "Person"
    Then can see preloader in Data Source
    Then can see Person windows
    When choose Report from Data Source as "Visit"
    Then can see preloader in Data Source
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell
    When choose Report from Data Source as "Condition Occurrence"
    Then can see preloader in Data Source
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell
    When choose Report from Data Source as "Condition Era"
    Then can see preloader in Data Source
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell
    When choose Report from Data Source as "Procedure"
    Then can see preloader in Data Source
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell
    When choose Report from Data Source as "Drug Exposure"
    Then can see preloader in Data Source
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell
    When choose Report from Data Source as "Drug Era"
    Then can see preloader in Data Source
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell
    When choose Report from Data Source as "Measurement"
    Then can see preloader in Data Source
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell
    When choose Report from Data Source as "Observation"
    Then can see preloader in Data Source
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell
    When choose Report from Data Source as "Death"
    Then can see preloader in Data Source
    Then can see Death windows
    When choose Report from Data Source as "Achilles Heel"
    Then can see preloader in Data Source
    Then can see Achilles Heel windows


  @qt_ds @qt_ovh02synpuf110k @odysseus
  Scenario: Quick test OVH02 SynPUF 110k
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "OVH02 SynPUF 110k"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page
    When Data Source Page opened
    When choose Report from Data Source as "Data Density"
    Then can see preloader in Data Source
    Then can see Data Density windows
    When choose Report from Data Source as "Person"
    Then can see preloader in Data Source
    Then can see Person windows
    When choose Report from Data Source as "Visit"
    Then can see preloader in Data Source
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell
    When choose Report from Data Source as "Condition Occurrence"
    Then can see preloader in Data Source
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell
    When choose Report from Data Source as "Condition Era"
    Then can see preloader in Data Source
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell
    When choose Report from Data Source as "Procedure"
    Then can see preloader in Data Source
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell
    When choose Report from Data Source as "Drug Exposure"
    Then can see preloader in Data Source
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell
    When choose Report from Data Source as "Drug Era"
    Then can see preloader in Data Source
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell
    When choose Report from Data Source as "Measurement"
    Then can see preloader in Data Source
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell
    When choose Report from Data Source as "Observation"
    Then can see preloader in Data Source
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell
    When choose Report from Data Source as "Death"
    Then can see preloader in Data Source
    Then can see Death windows
    When choose Report from Data Source as "Achilles Heel"
    Then can see preloader in Data Source
    Then can see Achilles Heel windows

  @qt_ds @qt_synpuf110kcost&util @odysseus
  Scenario: Quick test SynPUF 110k Cost&Util
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K Cost&Util"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page
    When Data Source Page opened
    When choose Report from Data Source as "Data Density"
    Then can see preloader in Data Source
    Then can see Data Density windows
    When choose Report from Data Source as "Person"
    Then can see preloader in Data Source
    Then can see Person windows
    When choose Report from Data Source as "Visit"
    Then can see preloader in Data Source
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell
    When choose Report from Data Source as "Condition Occurrence"
    Then can see preloader in Data Source
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell
    When choose Report from Data Source as "Condition Era"
    Then can see preloader in Data Source
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell
    When choose Report from Data Source as "Procedure"
    Then can see preloader in Data Source
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell
    When choose Report from Data Source as "Drug Exposure"
    Then can see preloader in Data Source
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell
    When choose Report from Data Source as "Drug Era"
    Then can see preloader in Data Source
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell
    When choose Report from Data Source as "Measurement"
    Then can see preloader in Data Source
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell
    When choose Report from Data Source as "Observation"
    Then can see preloader in Data Source
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell
    When choose Report from Data Source as "Death"
    Then can see preloader in Data Source
    Then can see Death windows
    When choose Report from Data Source as "Achilles Heel"
    Then can see preloader in Data Source
    Then can see Achilles Heel windows

  @qt_ds @qt_synpuf110kcdm5.3 @odysseus
  Scenario: Quick test SynPUF 110k CDM5.3
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 110K CDM5.3"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page
    When Data Source Page opened
    When choose Report from Data Source as "Data Density"
    Then can see preloader in Data Source
    Then can see Data Density windows
    When choose Report from Data Source as "Person"
    Then can see preloader in Data Source
    Then can see Person windows
    When choose Report from Data Source as "Visit"
    Then can see preloader in Data Source
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell
    When choose Report from Data Source as "Condition Occurrence"
    Then can see preloader in Data Source
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell
    When choose Report from Data Source as "Condition Era"
    Then can see preloader in Data Source
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell
    When choose Report from Data Source as "Procedure"
    Then can see preloader in Data Source
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell
    When choose Report from Data Source as "Drug Exposure"
    Then can see preloader in Data Source
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell
    When choose Report from Data Source as "Drug Era"
    Then can see preloader in Data Source
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell
    When choose Report from Data Source as "Measurement"
    Then can see preloader in Data Source
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell
    When choose Report from Data Source as "Observation"
    Then can see preloader in Data Source
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell
    When choose Report from Data Source as "Death"
    Then can see preloader in Data Source
    Then can see Death windows
    When choose Report from Data Source as "Achilles Heel"
    Then can see preloader in Data Source
    Then can see Achilles Heel windows

  @qt_ds @qt_synpuf2.3m(GCPbigQuery) @odysseus
  Scenario: Quick test SynPUF 2.3m (GCP BigQuery)
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2.3m (GCP BigQuery)"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page
    When Data Source Page opened
    When choose Report from Data Source as "Data Density"
    Then can see preloader in Data Source
    Then can see Data Density windows
    When choose Report from Data Source as "Person"
    Then can see preloader in Data Source
    Then can see Person windows
    When choose Report from Data Source as "Visit"
    Then can see preloader in Data Source
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell
    When choose Report from Data Source as "Condition Occurrence"
    Then can see preloader in Data Source
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell
    When choose Report from Data Source as "Condition Era"
    Then can see preloader in Data Source
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell
    When choose Report from Data Source as "Procedure"
    Then can see preloader in Data Source
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell
    When choose Report from Data Source as "Drug Exposure"
    Then can see preloader in Data Source
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell
    When choose Report from Data Source as "Drug Era"
    Then can see preloader in Data Source
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell
    When choose Report from Data Source as "Measurement"
    Then can see preloader in Data Source
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell
    When choose Report from Data Source as "Observation"
    Then can see preloader in Data Source
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell
    When choose Report from Data Source as "Death"
    Then can see preloader in Data Source
    Then can see Death windows
    When choose Report from Data Source as "Achilles Heel"
    Then can see preloader in Data Source
    Then can see Achilles Heel windows


  @qt_ds @qt_synpuf2mcdm5.3 @odysseus
  Scenario: Quick test SynPUF 2M CDM5.3
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "SynPUF 2M CDM5.3"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page
    When Data Source Page opened
    When choose Report from Data Source as "Data Density"
    Then can see preloader in Data Source
    Then can see Data Density windows
    When choose Report from Data Source as "Person"
    Then can see preloader in Data Source
    Then can see Person windows
    When choose Report from Data Source as "Visit"
    Then can see preloader in Data Source
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell
    When choose Report from Data Source as "Condition Occurrence"
    Then can see preloader in Data Source
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell
    When choose Report from Data Source as "Condition Era"
    Then can see preloader in Data Source
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell
    When choose Report from Data Source as "Procedure"
    Then can see preloader in Data Source
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell
    When choose Report from Data Source as "Drug Exposure"
    Then can see preloader in Data Source
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell
    When choose Report from Data Source as "Drug Era"
    Then can see preloader in Data Source
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell
    When choose Report from Data Source as "Measurement"
    Then can see preloader in Data Source
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell
    When choose Report from Data Source as "Observation"
    Then can see preloader in Data Source
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell
    When choose Report from Data Source as "Death"
    Then can see preloader in Data Source
    Then can see Death windows
    When choose Report from Data Source as "Achilles Heel"
    Then can see preloader in Data Source
    Then can see Achilles Heel windows


  @qt_ds @qt_oracle-110k @odysseus
  Scenario: Quick test oracle-110k
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "oracle-110k"
    When choose Report from Data Source as "Dashboard"
    Then can see windows in DASHBOARD page
    When Data Source Page opened
    When choose Report from Data Source as "Data Density"
    Then can see preloader in Data Source
    Then can see Data Density windows
    When choose Report from Data Source as "Person"
    Then can see preloader in Data Source
    Then can see Person windows
    When choose Report from Data Source as "Visit"
    Then can see preloader in Data Source
    Then can see Visit windows
    When click to element in prevalence in table
    Then can see tables in Visit for cell
    When choose Report from Data Source as "Condition Occurrence"
    Then can see preloader in Data Source
    Then can see Condition windows
    When click to element in prevalence in table
    Then can see tables in Condition for cell
    When choose Report from Data Source as "Condition Era"
    Then can see preloader in Data Source
    Then can see Condition Era windows
    When click to element in prevalence in table
    Then can see tables in Condition era for cell
    When choose Report from Data Source as "Procedure"
    Then can see preloader in Data Source
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell
    When choose Report from Data Source as "Drug Exposure"
    Then can see preloader in Data Source
    Then can see Drug windows
    When click to element in prevalence in table
    Then can see tables in Drugs for cell
    When choose Report from Data Source as "Drug Era"
    Then can see preloader in Data Source
    Then can see Drug Era windows
    When click to element in prevalence in table
    Then can see tables in Drugs Era for cell
    When choose Report from Data Source as "Measurement"
    Then can see preloader in Data Source
    Then can see Measurement windows
    When click to element in prevalence in table
    Then can see tables in Measurement for cell
    When choose Report from Data Source as "Observation"
    Then can see preloader in Data Source
    Then can see Observation windows
    When click to element in prevalence in table
    Then can see tables in Observation for cell
    When choose Report from Data Source as "Death"
    Then can see preloader in Data Source
    Then can see Death windows
    When choose Report from Data Source as "Achilles Heel"
    Then can see preloader in Data Source
    Then can see Achilles Heel windows


