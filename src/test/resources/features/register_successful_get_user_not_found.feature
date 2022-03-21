# new feature
# Tags: optional

Feature: Registro
  Como cliente interesado en los servicios
  Quiero poder registrarme en la página
  Para poder bucar mi informacion

  Scenario: Registro
    Given   se le piden al usuario unas credenciales de correo "eve.holt@reqres.in" y contrasenia "pistol" para registrarlo
    When    Hace la peticion de registro
    Then    le sale un mensaje de ok, y se le asigna un id, junto con un accesToken


  Scenario: no recibe datos
    Given   El usuario se registro quiere ver su informacion pero no busco de la forma correcta
    When    El usuario hace la peticion para el registro
    Then    Le sale al usuario un codigo que no encuentra resultados