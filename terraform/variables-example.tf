variable "token" {
    description = "Linode API access token."
    type = string
    default = "YOUR_LINODE_API_TOKEN"
}

variable "region" {
    description = "Region where the linode instance will be deployed."
    default = "YOUR_REGION"
}

variable "root_pass" {
    description = "Password for the root user."
    default = "YOUR_ROOT_PASSWORD"
}
