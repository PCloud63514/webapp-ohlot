#! /bin/bash
# ./gradlew 파일 실행할 줄 알아야함
# bootClean bootJar bootRun 할줄 알아야함
# 특정 서버를 대상으로할지 전체를 대상으로 할지 지정할 수 있어야함
# 지정 방식은 all 또는 배열 형태로 각 서비스 명을 입력하는 것

# 할 수 있는 일. dockerImage 배포, jar 배포, jar 실행
# applications 폴더 읽을 수 있어야함

function applications_show() {
  echo "==== 서비스 목록 ===="
  SERVICES=($(ls -d applications/* | cut -f 2 -d '/' | grep -e 'app-*' -e 'web-*'))
  # shellcheck disable=SC2068
  for service in ${SERVICES[@]}; do
    echo ${service}
  done
  echo "=================="
}

function read_applications() {
  read -a READ_SERVICES -p "입력 > "

  if [ -z "$READ_SERVICES" ]; then
    READ_SERVICES+=(${SERVICES[@]})
  fi
  clear
  echo "==== 대상 서비스 확인 ===="

  for service in ${READ_SERVICES[@]} ; do
    echo ${service}
  done

  echo "======================"
}

function jar_run() {
  clear
  echo "Jar 실행 서비스"
  echo "실행 가능한 서비스 목록 불러오는 중"
  echo "실행하고자 하는 서비스를 입력해주세요. (배열입력 또는 입력하지 않을 경우 전체 서비스 실행입니다.)"
  applications_show
  read_applications
}

function jar_deployment() {
  echo "[2]. Jar 배포"
}

function docker_image_deployment() {
  echo "[3]. Docker Image 배포"
}

function jar_and_docker_image_deployment() {
  echo "[4]. Jar & Docker Image 배포"
}

echo "[1]. Jar 실행"
echo "[2]. Jar 배포"
echo "[3]. Docker Image 배포"
echo "[4]. Jar & Docker Image 배포"

# shellcheck disable=SC2162
read CHOICE
clear

case ${CHOICE} in
1)
  jar_run
  ;;
2)
  jar_deployment
  ;;
3)
  docker_image_deployment
  ;;
4)
  jar_and_docker_image_deployment
  ;;
*)
  echo "Error"
  ;;
esac
