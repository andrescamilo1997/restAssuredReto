# new feature
# Tags: optional

Feature: Registro invalido
  Como usuario
  Quiero poder registrarme en la página
  Para poder bucar mi informacion



  Scenario: Registro inválido
    Given como administrador se ponen las credenciales del usuario, como el email "sydney@fife" pero no password
    When  cuando hace la peticion de registro
    Then  Recibe codigo y un mensaje de error, necesita password


  Scenario: Llamar lista de usuarios
    Given como administrador me gustaria ver la lista de usuarios para verificar si el usuario esta registrado
    When  cuando hace la peticion de ver lista
    Then  Recibe codigo y un mensaje, con todas las listas