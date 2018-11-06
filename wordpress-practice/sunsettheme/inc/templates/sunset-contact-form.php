<h1>Sunset Contact Form</h1>
<?php settings_errors(); ?>
<?php
  // $picture = esc_attr( get_option('profile_picture'));
  // $firstName = esc_attr( get_option('first_name'));
  // $lastName = esc_attr( get_option('last_name'));
  // $fullName = $firstName.' '.$lastName;
	// $description = esc_attr( get_option( 'user_description' ) );
?>

<form class="sunset-general-form" action="options.php" method="post">
  <?php settings_fields('sunset-contact-options'); ?>
  <?php do_settings_sections('sunset_admin_contact'); ?>
  <?php submit_button(); ?>
</form>
