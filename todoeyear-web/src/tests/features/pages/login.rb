class LoginPage < SitePrism::Page
  set_url '/login.xhtml'

  element :email, '#email'
  element :senha, '#senha'
  element :login_button, '#login-button'
  element :signup_button, '#signup-button'

  def login _email, _senha
    email.set _email
    senha.set _senha
    wait_for_login_button
    login_button.click
  end
  
end