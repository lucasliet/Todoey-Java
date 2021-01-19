Então('checo se estou na página de login.') do
  expect(page).to have_current_path('http://localhost:8080/todoeyear-web/login.xhtml')
end

Quando('eu insiro e-mail e senha.') do
  visit '/'
  fill_in id: 'email', with: 'lucasliet@test.com'
  fill_in id: 'senha', with: '123'
end

Então('clico para efetuar login.') do
  find('#login-button').click
end