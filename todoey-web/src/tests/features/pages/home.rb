class HomePage < SitePrism::Page
  set_url '/home.xhtml'

  elements :reminders_list, '.card-reminder'
  element :logout_button, '.logout-button'
  element :new_page_button, '#new-reminder-page-button'

  def logout
    wait_for_logout_button
    logout_button.click
  end
  
end