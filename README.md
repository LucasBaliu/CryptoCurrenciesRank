# Crypto Currencies Rank

# Sobre o projeto

Crypto Currencies Rank e uma aplicação que consome duas Api's externas para capturar atributos atualizados de cripto moedas.
O projeto visa manter, atualizada, uma lista das 10 cripto moedas de maior valor de mercado. O tipo de retorno do valor é da escolha do usuário,
bastando apenas incluir o valor de retorno desejado no endpoint após "/cryptocurrencyrank"

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- Maven

# Como executar o projeto

## Back end
Pré-requisitos: Java 21, IDEA IntelliJ

```bash
# clonar repositório
git clone https://github.com/LucasBaliu/CryptoCurrenciesRank

# executar o projeto

# Utilizar os endpoints de acordo com o tipo de moeda fiduciária que você quer como retorno de valor (/usd, /brl, /eur...)

# url localhost:8080/cryptocurrencyrank/(usd, brl, eur, aud...)

# O retorno será uma lista do seguinte objeto:
    {
        "price": BigDecimal,
        "id": String,
        "name": String,
        "symbol": String,
        "rank": Integer,
        "type": String,
        "is_active": Boolean,
        "is_new": Boolean
    }

# Caso a moeda requisitada no endpoint seja inválida, ainda terá o retorno do objeto acima porém os preços viram como null
```

# Autor

Lucas Ali Baliu

https://github.com/LucasBaliu
