# new feature
# Tags: optional

Feature: El usuario busca ser iniciar sesion
  Como cliente
  Quisiera poder iniciar mi sesion
  para poder hacer uso de mi cuenta y ver mis datos


  Scenario: Inicio de sesion exitoso
    Given :  El usuario ingresa su "eve.holt@reqres.in" y "cityslicka"
    When  :  clickea para ingresar
    Then  :  Le sale un codigo de respuesta y un token de acceso


  Scenario: Un usuario quiere buscar sus credenciales
    Given : un usuario busca cuales son sus datos registrados
    When  : hace clik para buscar sus datos
    Then  : Recibe un codigo de estatus y sus credenciales