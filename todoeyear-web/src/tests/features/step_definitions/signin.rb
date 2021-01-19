Quando('clico para cadastrar.') do
  visit '/login.xhtml'
  find('#signup-button').click
  signup_page = SignupPage.new
  signup_page.cadastrar 'usuario@test.com', '123'
end