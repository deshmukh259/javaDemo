resource "aws_s3_bucket" "" {
  bucket = "abcd",

}
variable "s3_name" {
  default = "s3_name"
}
