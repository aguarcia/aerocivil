Feature: Estados Financieros Aeronautica Civil
  Yo como usuario
  Quiero una página web
  Para descargar los informes financieros

  Scenario: Descargar Estado Financiero
    Given Agustin ingresa a la web de Aerocivil
    When navega hasta los estados financieros
    And selecciona mes a descargar
    Then se realiza la descarga de un documento PDF