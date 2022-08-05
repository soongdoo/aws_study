#!/usr/bin/env bash

# 쉬고 있는 profile 찾기: real1이 사용 중이면 real2가 쉬고 있고, 반대면 real1이 쉬고 있음

function find_idle_profile() {
    RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://localhost/profile)
    # 현재 엔진엑스가 바라보고 있는 스프링 부트가 정상적으로 수행 중인지 확인
    # 응답값을 HttpStatus 로 받습니다.
    # 정상이면 200, 오류 발생 시 400~503 사이로 발생하니 400 이상은 모두 예외로 보고 real2를 현재 profile 로 사용

    if [ ${RESPONSE_CODE} -ge 400 ] # 400보다 크면 즉, 40x/50x 에러 모두 포함

    then
      CURRENT_PROFILE=real2
    else
      CURRENT_PROFILE=$(curl -s http://localhost/profile)
    fi

    if [ ${CURRENT_PROFILE} == real1 ];
    then
      IDLE_PROFILE=real2
      # 엔진엑스와 연결되지 않은 profile 입니다.
      # 스프링 부트 프로젝트를 이 profile 로 연결하기 위해 반환합니다.
    else
      IDLE_PROFILE=real1
    fi

    echo "${IDLE_PROFILE}"
    # bash 스크립트는 갑승ㄹ 반환하는 기능이 없어서 제일 마지막 줄에 echo로 결과를  출력 후, 클라이엍느에서 그 값을 잡아서
    # $(find_idle_profile)로 사용 중간에 echo를 사용하면 안된다.
}

# 쉬고 있는 profile의 port 찾기
function find_idle_port() {
    IDLE_PROFILE=$(find_idle_profile)

    if [ ${IDLE_PROFILE} == real1 ];
    then
      echo "8081"
    else
      echo "8082"
    fi
}