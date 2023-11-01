# HQGiftBox 스크립트 애드온
스크립트에서 HQGiftBox 플러그인 API 사용을 돕는 스크립트 애드온입니다.

## 다운로드
* 플러그인 다운로드는 [릴리즈](https://github.com/HQService/HQGiftBoxSK/releases)에서 가능합니다.

## 디스코드
* 모든 문의, 질문, 개발 요청은 [디스코드](https://discord.gg/hqservice)에서 해주시길 바랍니다.

## 필수 플러그인
*  [HQFramework](https://github.com/HQService/HQFramework)

## 버전
* 1.18~1.20.2

## 기능
* 아이템을 유저의 선물함으로 보낼 수 있습니다.

## 사용법
```
command /보내기 [<player>]:
    trigger:
        set {_giftbox} to giftbox named "&6내가 만든 쿠키" with lore "&f너를 위해 구웠지" and "&7맛도리" with item player's tool
        if arg-1 is not set:
            gift {_giftbox} to all players
            send "선물을 모든 유저에게 보냈습니다."
        else:
            gift {_giftbox} to arg-1
            send "선물을 %arg-1%님에게 보냈습니다."
```
```
# {item::*}에 아이템이 여러개 설정되어 있다고 가정
command /보내기2:
    trigger:
        set {_giftbox} to giftbox named "&6내가 만든 쿠키" with item {item::*}
        gift {_giftbox} to all players
```
