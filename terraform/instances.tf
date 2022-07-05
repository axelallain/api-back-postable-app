resource "linode_instance" "nanode-1" {
	image = "linode/centos7"
	label = "postgres-db"
	group = "database"
	region = var.region
	type = "g6-nanode-1"
	# authorized_keys = { var.authorized_keys }
	root_pass = var.root_pass
}

resource "linode_instance" "nanode-2" {
	image = "linode/centos7"
	label = "api-postable-app"
	group = "centos"
	region = var.region
	type = "g6-nanode-1"
	# authorized_keys = [ var.authorized_keys ]
	root_pass = var.root_pass
}
