Quando('insiro os dados e clico em cadastrar.') do
  signup_page.load
  @random_user = "usuario#{rand *100000}@test.com"
  signup_page.cadastrar @random_user, '123'
end

Quando('logo com usuário criado aleatóriamente.') do
  login_page.load
  login_page.login @random_user, '123'
  expect(page).to have_current_path('/todoey/home.xhtml', ignore_query: true)
end