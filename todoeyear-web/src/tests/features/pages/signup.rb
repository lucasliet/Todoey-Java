class SignupPage < SitePrism::Page
  set_url '/signup.xhtml'

  element :email, '#email'
  element :senha, '#senha'
  element :signin_button, '#signup-button'

  def cadastrar _email, _senha
    email.set _email
    senha.set _senha
    wait_for_signin_button
    signin_button.click
  end
  
end