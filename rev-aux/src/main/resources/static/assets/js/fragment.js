function activateSubMenuItem(menuId, iconId, iconSrc, headerTitle, headerSubtitle) {


		console.log("activateSubMenuItem");
		const allMenuSpans = document.querySelectorAll('.menu-sub span'); // Adjust the selector to fit your structure

		allMenuSpans.forEach(span => {
			span.classList.remove('active');
		});


		const selectedMenu = document.getElementById(menuId);

		console.log(selectedMenu);

		if (selectedMenu) {

			const submenuSpan = selectedMenu.querySelector(`#${menuId} span`);

			if (submenuSpan) {

				submenuSpan.classList.add('active');
			}
		}









		document.querySelectorAll('.tab-pane').forEach(tabPane => {
			tabPane.classList.remove('active'); // Hide all tabs
		});

		const correspondingTab = document.querySelector(`#${menuId} .sub-nav-item`).getAttribute('data-tab');
		if (correspondingTab) {
			const targetTab = document.getElementById(correspondingTab);
			if (targetTab) {
				targetTab.classList.add('active');
			}
		}

		const headerTitleElement = document.getElementById('header-title');
		const headerSubtitleElement = document.getElementById('header-subtitle');
		if (headerTitleElement && headerSubtitleElement) {
			headerTitleElement.textContent = headerTitle;
			headerSubtitleElement.textContent = headerSubtitle;
		}
	}
	function activateMenuItem(menuId, iconId, iconSrc, headerTitle, headerSubtitle) {

		console.log("activateMenuItem");




		document.querySelectorAll('.menu-item').forEach(item => {
			item.classList.remove('active');
			const menuTitle = item.querySelector('.menu-title');
			if (menuTitle) {
				menuTitle.style.color = ''; // Reset the text color
			}
		});


		document.querySelectorAll('.menu-icon img').forEach(img => {
			if (img && img.getAttribute('data-default-src')) {
				img.src = img.getAttribute('data-default-src'); // Reset the icon
			}
		});


		const selectedMenu = document.getElementById(menuId);

		const allMenuLinks = document.querySelectorAll('.menu-link.nav-item, .menu-sub .menu-link');
		allMenuLinks.forEach((menuLink) => {
			menuLink.classList.remove('active');
		});


		if (selectedMenu) {

			const selectedSubMenu = selectedMenu.closest('.menu-sub');
			if (selectedSubMenu) {

				selectedMenu.classList.add('active');


				const parentMenu = selectedSubMenu.closest('.menu-item.menu-accordion');
				if (parentMenu) {
					const parentMenuLink = parentMenu.querySelector('.menu-link.nav-item');
					if (parentMenuLink) {
						parentMenuLink.classList.add('active');
						const menuTitle = parentMenuLink.querySelector('.menu-title');
						if (menuTitle) {
							menuTitle.style.color = 'white'; // Keep parent text highlighted
						}
					}
				}
			} else {
				// If it's a parent menu, highlight it directly
				const menuLink = selectedMenu.querySelector('.menu-link.nav-item');
				if (menuLink) {
					menuLink.classList.add('active');
					const menuTitle = menuLink.querySelector('.menu-title');
					if (menuTitle) {
						menuTitle.style.color = 'white'; // Highlight parent menu text
					}
				}
			}
		}




		const selectedIcon = document.getElementById(iconId);
		if (selectedIcon) {
			const imgElement = selectedIcon.querySelector('img');
			if (imgElement) {
				imgElement.src = iconSrc; // Update the icon source
			}
		}


		const headerTitleElement = document.getElementById('header-title');
		const headerSubtitleElement = document.getElementById('header-subtitle');
		if (headerTitleElement && headerSubtitleElement) {
			headerTitleElement.textContent = headerTitle;
			headerSubtitleElement.textContent = headerSubtitle;
		}


		document.querySelectorAll('.tab-pane').forEach(tabPane => {
			tabPane.classList.remove('active'); // Hide all tabs
		});

		const correspondingTab = document.querySelector(`#${menuId} .nav-item`).getAttribute('data-tab');
		if (correspondingTab) {
			const targetTab = document.getElementById(correspondingTab);
			if (targetTab) {
				targetTab.classList.add('active'); // Show the corresponding tab
			}
		}
	}


	function parent_child_checkMenuItem(menuId, iconId, iconSrc, headerTitle, headerSubtitle) {
		console.log("activateMenuItem");


		const selectedMenu = document.getElementById(menuId);

		if (selectedMenu) {
			const isAlreadyOpen = selectedMenu.classList.contains('hover') && selectedMenu.classList.contains('show');


			document.querySelectorAll('.menu-item.menu-accordion').forEach(item => {
				if (item !== selectedMenu) {

					item.classList.remove('hover', 'show');
					const menuSub = item.querySelector('.menu-sub');
					if (menuSub) {
						menuSub.classList.remove('show');
						menuSub.style.display = 'none'; // Hide submenu
					}

					const menuLink = item.querySelector('.menu-link.nav-item');
					if (menuLink) {
						menuLink.classList.remove('active');
					}

					const menuTitle = item.querySelector('.menu-title');
					if (menuTitle) {
						menuTitle.style.color = ''; // Reset text color
					}

					const menuIcon = item.querySelector('.menu-icon img');
					if (menuIcon && menuIcon.getAttribute('data-default-src')) {
						menuIcon.src = menuIcon.getAttribute('data-default-src'); // Reset the icon
					}
				}
			});


			if (isAlreadyOpen) {

				selectedMenu.classList.remove('hover', 'show');
				const selectedSubMenu = selectedMenu.querySelector('.menu-sub');
				if (selectedSubMenu) {
					selectedSubMenu.classList.remove('show');
					selectedSubMenu.style.display = 'none';
				}

				const menuLink = selectedMenu.querySelector('.menu-link.nav-item');
				if (menuLink) {
					menuLink.classList.remove('active');
				}

				const menuTitle = selectedMenu.querySelector('.menu-title');
				if (menuTitle) {
					menuTitle.style.color = '';
				}
			}
			else {

				selectedMenu.classList.add('hover', 'show');
				const selectedSubMenu = selectedMenu.querySelector('.menu-sub');
				if (selectedSubMenu) {
					selectedSubMenu.classList.add('show');
					selectedSubMenu.style.display = ''; // Show submenu
				}


				const menuLink = selectedMenu.querySelector('.menu-link.nav-item');
				if (menuLink) {
					menuLink.classList.add('active');
				}


				const menuTitle = selectedMenu.querySelector('.menu-title');
				if (menuTitle) {
					menuTitle.style.color = 'white';
				}


				const selectedIcon = document.getElementById(iconId);
				if (selectedIcon) {
					const imgElement = selectedIcon.querySelector('img');
					if (imgElement) {
						imgElement.src = iconSrc;
					}
				}


				const headerTitleElement = document.getElementById('header-title');
				const headerSubtitleElement = document.getElementById('header-subtitle');
				if (headerTitleElement && headerSubtitleElement) {
					headerTitleElement.textContent = headerTitle;
					headerSubtitleElement.textContent = headerSubtitle;
				}


				document.querySelectorAll('.tab-pane').forEach(tabPane => {
					tabPane.classList.remove('active'); // Hide all tabs
				});

				const correspondingTab = document.querySelector(`#${menuId} .nav-item`)?.getAttribute('data-tab');
				if (correspondingTab) {
					const targetTab = document.getElementById(correspondingTab);
					if (targetTab) {
						targetTab.classList.add('active');
					}
				}
			}
		}
	}

	document.getElementById('admin-menu')?.addEventListener('click', function () {
		const allMenuSpans = document.querySelectorAll('.menu-sub span'); // Adjust the selector to fit your structure

		allMenuSpans.forEach(span => {
			span.classList.remove('active');
		});

		activateMenuItem('admin-menu', 'admin-icon', 'assets/admin_blue_icon.svg', 'Admin Module', 'Admin Permission');
	});

	document.getElementById('admin-permission-menu')?.addEventListener('click', function () {

		event.stopPropagation();
		activateSubMenuItem('admin-permission-menu', 'admin-permission-menu', 'assets/quote_blue_icon.svg', 'Admin Permission', 'Admin Permission Management');

	});

	document.getElementById('quote-setting-menu')?.addEventListener('click', function () {
		event.stopPropagation();
		activateSubMenuItem('quote-setting-menu', 'quote-setting-menu', 'assets/quote_blue_icon.svg', 'Quote Setting', 'Quote Setting Management');

	});

	document.getElementById('dashboard-menu')?.addEventListener('click', function () {
		activateMenuItem('dashboard-menu', 'dashboard-icon', 'assets/dashboard_blue_icon.svg', 'Dashboard Module', 'Dashboard Overview');
	});

	document.getElementById('quote-menu')?.addEventListener('click', function () {

		const allMenuSpans = document.querySelectorAll('.menu-sub span'); // Adjust the selector to fit your structure

		allMenuSpans.forEach(span => {
			span.classList.remove('active');
		});
		activateMenuItem('quote-menu', 'quote-icon', 'assets/quote_blue_icon.svg', 'Quote Module', 'Quote Management');
	});




	document.getElementById('nt-quote-menu')?.addEventListener('click', function () {

		event.stopPropagation();
		activateSubMenuItem('nt-quote-menu', 'nt-quote-menu', 'assets/quote_blue_icon.svg', 'Quote Module', 'NT Quote');

	});

document.getElementById('nt-quote-menu2')?.addEventListener('click', function () {
	event.stopPropagation();
		activateSubMenuItem('nt-quote-menu2', 'nt-quote-menu2', 'assets/quote_blue_icon.svg', 'NT Quote Module', 'NT Quote Management');

	});

	document.getElementById('vendor-menu')?.addEventListener('click', function () {
		parent_child_checkMenuItem('vendor-menu', 'vendor-icon', 'assets/vendor_blue_icon.svg', 'Vendor Module', 'Vendor Management');
	});

document.getElementById('procurement-menu')?.addEventListener('click', function () {
	activateMenuItem('procurement-menu', 'procurement-icon', 'assets/procurement_blue_icon.svg', 'Procurement Module', 'Procurement Module');
	});

	document.getElementById('procurement-rfq-menu')?.addEventListener('click', function () {

		event.stopPropagation();
		activateSubMenuItem('procurement-rfq-menu', 'procurement-rfq-menu', 'assets/quote_blue_icon.svg', 'Procurement Module', 'RFQ');

	});



	document.getElementById('logout-menu')?.addEventListener('click', function () {
		parent_child_checkMenuItem('logout-menu', 'logout-icon', 'assets/logout_blue_icon.svg', 'Logout', 'You have been logged out');
	});

	// Set Admin tab as default on page load
	window.onload = function () {
		activateMenuItem('admin-menu', 'admin-icon', 'assets/admin_blue_icon.svg', 'Admin Module', 'Admin Permission');
	};




	document.querySelectorAll('#admin_section_tabs .admin_nav-item button').forEach((tab) => {

		tab.addEventListener('click', () => {
			// Remove active class from all tabs
			document.querySelectorAll('#admin_section_tabs .admin_nav-item button').forEach((btn) => {
				btn.classList.remove('active');
			});

			// Hide all tab content
			document.querySelectorAll('.admin_section_tab-pane').forEach((pane) => {
				pane.classList.remove('active');
			});

			// Add active class to the clicked tab and its content
			const tabId = tab.getAttribute('data-tab');
			tab.classList.add('active');
			document.getElementById(tabId).classList.add('active');
		});
	});



	document.querySelectorAll('#procurement-rfq_tabs .nav-item button').forEach((tab) => {

		tab.addEventListener('click', () => {

			document.querySelectorAll('#procurement-rfq_tabs .nav-item button').forEach((btn) => {
				btn.classList.remove('active');
			});


			document.querySelectorAll('.procurement-rfq_tab-pane').forEach((pane) => {
				pane.classList.remove('active');
			});


			const tabId = tab.getAttribute('data-tab');
			tab.classList.add('active');
			document.getElementById(tabId).classList.add('active');
		});
	});







	document.querySelectorAll('#nt_quote_tabs .nav-item button').forEach((tab) => {

		tab.addEventListener('click', () => {

			document.querySelectorAll('#nt_quote_tabs .nav-item button').forEach((btn) => {
				btn.classList.remove('active');
			});


			document.querySelectorAll('.nt_quote_tab-pane').forEach((pane) => {
				pane.classList.remove('active');
			});


			const tabId = tab.getAttribute('data-tab');
			tab.classList.add('active');
			document.getElementById(tabId).classList.add('active');
		});
	});