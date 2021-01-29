Então('checo se estou na página de login.') do
  expect(page).to have_current_path('/todoey-web/login.xhtml', ignore_query: true)
end

Então('checo se estou na página home.') do
  expect(page).to have_current_path('/todoey-web/home.xhtml', ignore_query: true)
end

Quando('eu insiro os dados e clico em logar.') do
  login_page.load
  login_page.login 'lucasliet@test.com', '123'
end

Quando('eu clico no botão de logout.') do
  home_page.load
  home_page.logout
end