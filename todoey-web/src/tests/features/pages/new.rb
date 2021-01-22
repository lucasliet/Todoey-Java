class NewPage < SitePrism::Page
  set_url '/new.xhtml'

  element :title, '#reminder_title'
  element :deadline, '#reminder_deadline'
  element :body, '#reminder_body'
  element :save_button, '#save-button'
  element :error_messages, '.error-messages > li'

  def register_reminder _title, _deadline, _body
    title.set _title
    deadline.set _deadline
    body.set _body
    wait_for_save_button
    save_button.click
  end

end