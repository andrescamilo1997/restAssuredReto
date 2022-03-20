# new feature
# Tags: optional

Feature: Editar informaciòn
  Como cliente
  Quisiera poder editar mi informacion
  para poder mantener actualizados mis contactos

  Scenario: edicion de contacto
    Given el cliente pide editar alguno de sus datos "identificacion" y "trabajo"
    When  hace la peticion
    Then  recibe un codigo de respuesta exitoso y su identificacion, trabajo y fecha