#language: pt

@users
Funcionalidade: logar no site.

@login
Cenário: Logar com sucesso.
Quando eu insiro os dados e clico em logar.
Então checo se estou na página home.

@logout
Cenário: Deslogar com sucesso.
Quando eu clico no botão de logout.
Então checo se estou na página de login.

@signup
Cenário: Cadastrar com sucesso.
Quando insiro os dados e clico em cadastrar.
E logo com usuário criado aleatóriamente.
Então checo se estou na página home.