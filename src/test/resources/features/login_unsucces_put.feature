# new feature
# Tags: optional

Feature: El cliente trata inisiar sesion
  como clinete
  quiero poder iniciar sesión
  para poder editar mis credenciales

  Scenario: Inicio de sesion no exitoso
    Given El usuario ingresa su "eve.holt@reqres.in" pero no su contracenia
    When  El usuario hace la peticion
    Then  El usuario recibe un codigo y un mensaje de falta passwor


  Scenario: El cliente hace un cambio de credenciales
    Given el cliente pide editar alguno de sus datos "morpheus" y "zion resident"
    When  hace la peticion
    Then  recibe un codigo de respuesta exitoso y su identificacion, trabajo y fecha