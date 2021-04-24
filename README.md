# empresa_ioasys
# Aplicativo para exibir relação de empresas de diversas localidades.

# Sobre o aplicativo:
  O aplicativo é composto por três telas: Login, relação de empresas e tela com detalhes da empresa selecionada na lista.
  
# Instruções de acesso:
  Para realizar o login, é preciso que o usuário informe seu e-mail e senha de acesso.
  
# Pesquisando por empresas:
  Em seguida, é exibida a tela com um campo para o usuário informar o nome ou parte do nome da empresa que deseja pesquisar. 
  Caso a empresa informada não seja encontrada, o aplicativo retorna mensagem informando que a determinada empresa não existe.
  Ao relacionar uma ou mais empresas existentes, o usuário pode clicar em uma delas, que logo em seguida
  será direcionado à tela de detalhamento da empresa selecionada.
  
# Empresa selecionada:
  Com a empresa selecionada, o usuário poderá ver mais detalhes sobre a empresa, cassim também com a foto mais ampliada da mesma.
  
# Origem dos dados:
  Todos os dados são provenientes de uma API, que foi utilizada a biblioteca retrofit2. Isso torna a conexão mais segura e simples de implementar.
  Assim também como a obtenção de falhas na conexão são mais consistentes.

# Biblioteca de imagem:
  Para cara empresa listada, é disponibilizada uma imagem, onde é carregada através do fremework Glide. Muito por sua fácil implementação, como também pelo
  bom desempenho no carregamento das imagens.
  
# Arquitetura utilizada no projeto:
  No projeto foi inciada a arquitetura MVP. Isso por conta do tempo de desenvolvimento, acabei decidindo por essa arquitetura. 
  Por achar mais simples de implementar. 
  
# Em caso de mais tempo:
  Teria trabalhado melhor na implantação dessa arquitetura ou até mudaria para MVVM.
  Como também por conta do tempo, não foi possível realizar testes unitários. Com mais um pouco de tempo isso seria possível. 
  Foi algo de importante que não deu pra realizar.
