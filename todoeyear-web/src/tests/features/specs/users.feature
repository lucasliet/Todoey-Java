#language: pt

@users
Funcionalidade: logar no site.

@login
Cenário: logar com sucesso.
Quando eu insiro e-mail e senha.
Então clico para efetuar login.

@logout
Cenário: deslogar com sucesso.
Quando eu clico no botão de logout.
Então checo se estou na página de login.

@signin
Cenário: Cadastrar com sucesso.
Quando eu insiro e-mail e senha.
E clico para cadastrar.
Então checo se estou na página de login.