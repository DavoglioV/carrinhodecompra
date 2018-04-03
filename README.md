# carrinhodecompra
API para Carrinho de compras na linguagem java usando Stack Spring. 
A API foi desenvolvida para poder ser acssada de qualquer outra aplciação externa.

Arquivos cadastrados: 
1  Mouse            R$ 15
2  Teclado          R$ 47.8
3  Monitor          R$250
4  Filtro de Linha  R$ 145.2
5  Mouse Wireless   R$ 47.9

A aplicação encontra-se no servidor Heroku no seguinte link:
https://carrinhodecompra.herokuapp.com

EndPoints
  -Adicionar novos produto
   POST https://carrinhodecompra.herokuapp.com/produto
   Exemple Json: 
    {
      "id": 2,
      "nome": "Produto 2",
      "valor: 25.5
    }
    
  -Remover produtos
   DELETE https://carrinhodecompra.herokuapp.com/produto/{id}
   Exemple https://carrinhodecompra.herokuapp.com/produto/2
   
  -Obter lista de produtos cadastrados
   GET https://carrinhodecompra.herokuapp.com/produto/
   
  -Adicionar item no carrinho de compras
   POST https://carrinhodecompra.herokuapp.com/carrinho
   Exempe Json:
   {
      "id": 2,
      "quantidade": 10    
   }
   
  -Remover item do carrinho de compras 
   DELETE https://carrinhodecompra.herokuapp.com/carrinho/{id}
   Exemple: https://carrinhodecompra.herokuapp.com/carrinho/2
   
  -Atualiza item que já existe no carrinho
   PUT https://carrinhodecompra.herokuapp.com/carrinho/{id}/{quantidade}
   Exemple: https://carrinhodecompra.herokuapp.com/carrinho/2/15
   
  -Obtem itens adicionasdos no carrinho
   GET https://carrinhodecompra.herokuapp.com/carrinho
    
