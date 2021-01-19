Quando('eu clico no botão de logout.') do
  @home = HomePage.new
  @home.load
  @home.logout
end