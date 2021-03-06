Feature: Calculate an IMC

  Scenario: In order to retrieve the user's IMC, I want to fill the fromeand get my IMC with its descriptions
    Given A running platform
    When The user opens <https://www.calculersonimc.fr/>
    Then The front page is displayed
    When The user clicks on Calculate
    Then The IMC form is displayed
    When The user selects the <1>'s gender
    And The user fill the height box with <170>
    And The user fill the weight box with <60>
    And The user fill the age box with <20>
    Then The IMC result box is displayed
    And The calculated IMC is <20.76 kg/m²>

  Scenario: FLUENT In order to retrieve the user's IMC, I want to fill the fromeand get my IMC with its descriptions
    Given FLUENT A running platform
    When FLUENT The user opens <https://www.calculersonimc.fr/>
    Then FLUENT The front page is displayed
    When FLUENT The user clicks on Calculate
    Then FLUENT The IMC form is displayed
    When FLUENT The user selects the <1>'s gender
    And FLUENT The user fill the height box with <170>
    And FLUENT The user fill the weight box with <60>
    And FLUENT The user fill the age box with <20>
    Then FLUENT The IMC result box is displayed
    And FLUENT The calculated IMC is <20.76 kg/m²>