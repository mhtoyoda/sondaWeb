# sondaWeb
Projeto Teste Elo7 - SondaWeb by Marcelo Toyoda

Este projeto visa simular comandos enviados para um conjunto de Sondas para explorar a malha do planalto.
Seguindo uma série de instruções de coordenadas e tendo como retorno a posição final das sondas.

*Na implementação assumiu-se que o ponto superior direito da malha é x = 5 e y = 5
*Caso as intruções de movimento ultrapassem o limite superior direito da malha, assumi que a posição final, seja da coordenada x ou y será igual
ao limite x e/ou y da malha do planalto.

*Para subir o Apache Tomcat basta executar o método main da classe SondaWebApplication.

*Aplicação iniciada em -> http://localhost:8080/

*Requisitos de sistema:
- IDE Eclipse
- Java JDK 1.8
- Spring Boot 1.3.3
- Maven 3
- Tomcat (Embedded)
- Rest Assured (Testes do serviço Rest)