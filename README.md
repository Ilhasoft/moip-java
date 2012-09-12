SDK Moip-Java
============================

O JMoip é uma biblioteca que implementa uma camada de abstração para geração do XML de instruções da Moip, permitindo que você gere instruções sem poluir seu código com várias linhas de XML. Um exemplo rápido:

        SendInstruction enviarInstrucao = new SendInstruction()
                .withSingleInstruction(new SingleInstruction()
                                        .withReason("Uma motivo pela compra")
                                        .withUniqueId("ID_PROPRIO")
                                        .with(new Values().withValue("10.00"))
                                      );

        SendSingleInstructionResponse response = new SandboxMoip()
                .withToken("01010101010101010101010101010101")
                .withKey("ABABABABABABABABABABABABABABABABABABABAB").send(enviarInstrucao);

        System.out.println(response.getXML());
	
Neste exemplo criamos uma Instrução Única básica, somente com razão, ID próprio e valor, e a enviamos ao Sandbox do Moip, imprimindo o XML de retorno. Se quiséssemos enviar para o ambiente de produção, bastaria usar a classe ProductionMoip no lugar de SandboxMoip, com token e chave válidos.

--------------------------------------------------

Overview das Classes
=====================

Enviadores (SandboxMoip e ProductionMoip)
--------------------
Servem para enviar dados para o Moip, abstraindo a forma de comunicação.
Use o construtor (token, key) ou os métodos withToken() e withKey() para configurar o token e chave usados.
Importante: ao definir o ambiente certifique-se de que está utilizando a autenticação correspondente ao ambiente. No Moip cada ambiente possui suas próprias chaves de autenticação da API.

SendSingleInstructionResponse send(SendInstruction enviarInstrucao)
-----------------------

Envia uma instrução representada pelo objeto SendInstruction , e devolve um objeto SendSingleInstructionResponse com os dados da resposta do Moip.

        SendInstruction enviarInstrucao = new SendInstruction()
                .withSingleInstruction(new SingleInstruction()
                                        .withReason("Uma motivo pela compra")
                                        .withUniqueId("ID_PROPRIO")
                                        .with(new Values().withValue("10.00"))
                                      );

        try {
                SendSingleInstructionResponse response = new SandboxMoip()
                        .withToken("01010101010101010101010101010101")
                        .withKey("ABABABABABABABABABABABABABABABABABABABAB").send(enviarInstrucao);

                if (response.isSuccessful()) {
                        System.out.println("Token:" + response.getResponse().getToken());
                } else {
                        System.out.println("Falha ao registrar instrução única no Moip!");
                        System.out.println("Erros:");
                        for(Error err : response.getResponse().getErrors()) {
                                System.out.println("Código: " + err.getCode() + ", Mensagem: " + err.getMessage());
                        }
                }
        } catch(MoipClientException ex) {
                System.out.println("Falha na comunicação com o Moip! Código de retorno HTTP:" + ex.getStatusCode());
                System.out.println("Causa: " + ex.getCause());
        }

Note que há duas formas de ocorrer problemas no registro da instrução: pode haver algum problema na comunicação em si, ou a violação de alguma regra do Moip ao mandar uma instrução inválida. No primeiro caso, o método send lança uma MoipClientException com o código HTTP de retorno e a exceção que causou o problema; no segundo caso, o Moip responde com um SendInstructionResponse com Status = FALHA, o que é validado pelo método isSuccessful(). No caso de falha, os erros estarão disponíveis no método getErrors(); em caso de sucesso, o Token da instrução estará disponível no método getToken().

-----------------------------------------------

CheckParcelValuesResponse send(QueryParcel query)
-----------------------
Envia uma consulta de parcelamento representada pelo objeto QueryParcel , e devolve um objeto CheckParcelValuesResponse com os dados da resposta do Moip.


        QueryParcel query = new QueryParcel("integracao@labs.moip.com.br", "12", "1.99", "100.00");

        try {
                CheckParcelValuesResponse response = new SandboxMoip()
                        .withToken("01010101010101010101010101010101")
                        .withKey("ABABABABABABABABABABABABABABABABABABABAB").send(query);

                if (response.isSuccessful()) {
                        for(ParcelValue value : response.getResponse().getValues()) {
                                System.out.println("Pagamento em " + value.getParcel() + 
                                                " parcelas de " + value.getValue() + 
                                                " cada, totalizando R$ " + value.getTotal());
                        }
                } else {
                        System.out.println("Falha ao registrar instrução única no Moip!");
                        System.out.println("Erros:");
                        for(Error err : response.getResponse().getErrors()) {
                                System.out.println("Código: " + err.getCode() + ", Mensagem: " + err.getMessage());
                        }
                }
        } catch(MoipClientException ex) {
                System.out.println("Falha na comunicação com o Moip! Código de retorno HTTP:" + ex.getStatusCode());
                System.out.println("Causa: " + ex.getCause());
        }

Note que podem ocorrer os mesmos erros do método anterior. Se tudo correr bem, o Moip devolverá um ParcelValuesResponse com uma lista de ParcelValue; cada um contendo o número de parcelas (getParcel()), o valor de cada parcela (getValue()) e o total que deverá ser pago (getTotal()).

-------------------------------------------------

Criação de Instrução: SendInstruction
=====================================

withSingleInstruction(SingleInstruction instrucaoUnica)
--------------------
Cria uma Instrução Única para mandar com esta instrução.

--------------------------------------------------

getXML()
----------
Devolve o XML que esta instrução gera.

-----------------------------------------------------

validate()
-------------
Valida esta instrução, lançando uma exceção com os campos faltantes. Note que não efetua a maioria das validações do Moip; simplesmente verifica a existência do básico. Para processar a validação do Moip, use o método isSuccessful() do SendInstructionResponse.

-----------------------------------------------------

Criação de Instrução: SingleInstruction
=================================

withTransparentValidation()
------------------
Configura a instrução para usar a validação transparente do Moip. Com isto, a maioria dos dados do pagador e o endereço de cobrança tornam-se obrigatórios. Necessário se estiver se integrando com o Moip Transparente.

------------------------------------------------------

validate()
-------------
Valida esta instrução, lançando uma exceção com os campos faltantes. Note que, se foi chamado o withTransparentValidation(), passa a validar a existência dos campos extras.

------------------------------------------------------

with...(...)
-------------
Use os métodos with() para incluir outros elementos no seu XML. Consulte o Javadoc para a relação entre as classes e seus elementos correspondentes no XML.

------------------------------------------------------
