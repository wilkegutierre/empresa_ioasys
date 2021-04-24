# empresa_ioasys
# Aplicativo para exibir relação de empresas de diversas localidades.
# O aplicativo é composto por três telas: Login, relação de empresas e tela com detalhes da empresa selecionada na lista.
# Para realizar o login, é preciso que o usuário informe seu e-mail e senha de acesso. em seguida, é exibida a tela para o usuário pesquisar, 
  por nomes, as empresas que desejar. Não encontrando, o aplicativo retorna mensagem informando que a determinada empresa não encontrada.
# Ao relacionar uma ou mais empresas existentes, o usuário pode clicar em uma delas, onde virão relacionadas numa lista, que logo em seguida
  será direcionado à tela de detalhamento da empresa selecionada.
  
# Todos os dados são provenientes de uma API, que foi utilizada a biblioteca retrofit2 para conexão. Isso torna a conexão mais segura e simples de implementar.
  Assim também como a obtenção de falhas na conexão são mais consistentes.

# Para cara empresa listada, é disponibilizada uma imagem, onde é carregada através do fremework Glide. Muito por sua fácil implementação, como também pelo
  bom desempenho no carregamento das imagens.
  
# No projeto foi inciada a arquitetura MVP. Isso por conta do tempo de desenvolvimento, acabei decidindo por essa arquitetura. 
  Por achar mais simples de implementar. Caso houvesse mais tempo, teria trabalhado melhor na implantação dessa arquitetura ou até mudaria para MVVM.
  Como tmbém, não foi possível realizar testes unitários. Com mais um pouco de tempo isso seria possível.
