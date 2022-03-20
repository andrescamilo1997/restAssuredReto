# new feature
# Tags: optional

Feature: Usuario Unico
  Como usuario
  quiero poder consultar mis credenciales
  para poder ver todos los datos que ahì se maneja

  Scenario: Un usuario quiere buscar sus credenciales
    Given un usuario busca cuales son sus datos registrados
    When  hace clik para buscar sus datos
    Then  Recibe un codigo de estatus y sus credenciales