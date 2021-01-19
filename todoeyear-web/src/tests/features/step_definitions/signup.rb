Quando('clico para cadastrar.') do
  signup_page.load
  signup_page.cadastrar "usuario#{rand *100000}@test.com", '123'
end