#language: pt
Funcionalidade: SOCTest
  Para que eu possa completar a avaliacao
  Sendo um candidato a vaga de analista qa
  Posso executar a automacao

  Esquema do Cenario: Buscar na barra de pesquisa
    Dado que eu acesso o site para busca
    Quando eu buscar por <busca>
    Entao eu vejo o resultado da busca <busca>

    Exemplos: 
      | busca               |
      | "vagas"             |
      | "analista de teste" |

  Esquema do Cenario: Estimar FAP
    Dado que eu acesso a pagina do FAP
    Quando preencher campo empresa com <empresa>
    E preencher campo fap com <fap>
    E preencher campo rat com <rat>
    E preencher campo de projecao de massa salarial com <projecao>
    E clicar para estimar o FAP
    Entao exibe o nome da empresa
    E exibe o resultado do calculo de recolhimento maximo
    E exibe o resultado do calculo de recolhimento minimo
    E exibe o resultado do calculo de passivel de economia

    Exemplos: 
      | empresa | fap | rat | projecao  |
      | "AGE"   |   1 |   1 | "1000.00" |
      | "AGE"   |   2 |   2 | "2000.00" |
      | "AGE"   |   3 |   3 | "3000.00" |
