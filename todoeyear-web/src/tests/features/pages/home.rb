class HomePage < SitePrism::Page
  set_url '/home.xhtml'

  elements :reminders_list, '.card-reminder'
  element :menu_button, 'button[id$=menu-button_button]'
  element :logout_button, 'a[id$=logout-button]'

  def logout
    wait_for_menu_button
    menu_button.click
    wait_for_logout_button
    logout_button.click
  end
  
end