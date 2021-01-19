Então('checo se estou na página de login.') do
  expect(page).to have_current_path('/todoeyear-web/login.xhtml', ignore_query: true)
end

Quando('eu insiro e-mail e senha.') do
  login_page.load
  login_page.login 'lucasliet@test.com', '123'
end