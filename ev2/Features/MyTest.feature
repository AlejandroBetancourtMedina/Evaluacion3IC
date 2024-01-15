
@tag
Feature: Pruebas a Login

  @tag1
  Scenario: Usuario Correcto
    
    When Abrir y ejecutar aplicacion web
       Then valida ingreso del usuaio "usuario" y "pass" logeado
    			When Inicia sesion correctamente

  @tag2
   Scenario: Usuario Incorrecto
	When Abrir y ejecutar aplicacion web
       Then valida ingreso del usuaio "usuario" y "pass" logeado
    			When Arroja error de login, se debn validar los accesos.
    			
    		
  @tag3
   Scenario: Ingresa valores vacios 
	When Abrir y ejecutar aplicacion web
       Then Ingresa dejando en blanco los blocktext del login
    			When Arroja Mensaje señalando error de datos

 