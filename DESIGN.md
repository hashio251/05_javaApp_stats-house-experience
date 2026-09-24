# STATUS HOUSE CLI 設計書

## 演習1 コンセプトシート

| 記入項目       | 内容                                                                                                               |
| ---------- | ---------------------------------------------------------------------------------------------------------------- |
| アプリ名       | STATUS HOUSE CLI - Visitor Log System                                                                            |
| コンセプト      | HTTPステータスコードをテーマにした館で、訪問者が各部屋に訪問記録を残し、その記録を登録・閲覧・編集・削除できるCLIアプリ                                                  |
| 作ろうと思った理由  | HTTPステータスコードはWeb開発で頻繁に使用するが、数字と意味だけを暗記すると覚えにくいと感じたため、CRUD操作の結果とHTTPステータスコードを関連付けることで、操作しながら意味を理解できるアプリを作りたいと考えた。 |
| 利用する人      | HTTPやWeb開発を学び始めた学生                                                                                               |
| 解決したい課題    | HTTPステータスコードの数字と意味が結び付きにくく、暗記だけでは忘れやすいこと                                                                         |
| アプリを使うメリット | 訪問記録の追加・閲覧・編集・削除とHTTPステータスコードを関連付けることで、CRUD処理とHTTPステータスコードの意味を体験的に学習できる。                                         |

---

## 演習2 ペルソナ

| 項目      | 記入内容                                       |
| ------- | ------------------------------------------ |
| 名前      | 山田 太郎                                      |
| 年齢      | 20歳                                        |
| 職業      | IT系専門学校生                                   |
| 趣味      | Web制作、脱出ゲーム、レトロゲーム                         |
| ITスキル   | HTML・CSS・JavaScriptを学習中。HTTPについて学び始めた段階    |
| 困っていること | 200や404は分かるが、401・403・201・204などの違いを覚えるのが難しい |
| 目的      | HTTPステータスコードの意味を、実際の処理と関連付けて覚えたい           |
| 利用場面    | アプリ開発やWeb開発の学習中に、HTTPステータスコードを復習するとき        |

---

## 演習3 ユーザーストーリー

| No. | ユーザーストーリー |
| --- | --- |
| 1 | 実際にHTTPステータスコードを体感し記録するため、訪問者ログを登録する。暗記で終わらせるのではなく、実際にルームコードやメッセージを登録し、記憶するため。     |
| 2 | 登録したログを一覧で確認する。どのようなルームコードやメッセージが登録されているのか確認するため。 |
| 3 | 登録したログの詳細を確認する。指定したログの名前、ルームコード、メッセージ、登録日時を確認するため。 |
| 4 | 登録した内容を編集する。後から変更をしたいと思った場合などに変更するため。    |
| 5 | 不要なログを削除する。誤って作成してしまったログなどを削除するため。     |
| 6 | IDからログを検索する。作成したIDごとにログを参照したい場合に使用するため。|


---

## 演習4 機能一覧

| No. | 機能名 | 概要 |
| --- | --- | --- |
| 1 | Visitor Check-in | 訪問者名・部屋番号・メッセージを入力してVisitor Logを登録する |
| 2 | Visitor Log List | 登録されているVisitor Logをすべて表示する |
| 3 | Visitor Log Details | IDを指定してVisitor Logの詳細を表示する |
| 4 | Edit Visitor Log | IDを指定してVisitor Logの内容を編集する |
| 5 | Delete Visitor Log | IDを指定してVisitor Logを削除する |
| 6 | Search by ID | IDからVisitor Logを検索する |
| 0 | Exit | アプリケーションを終了する |

### CRUDとの対応

| CRUD | 機能 |
| --- | --- |
| Create | Visitor Check-in |
| Read | Visitor Log List / Visitor Log Details / Search by ID |
| Update | Edit Visitor Log |
| Delete | Delete Visitor Log |

---

## 演習5 データ設計

| 項目名 | 内容 |
| --- | --- |
| id | Visitor Logを識別するための管理番号 |
| visitorName | 訪問者の名前 |
| roomCode | 訪問した部屋を表すHTTPステータスコード |
| message | 訪問者が残すメッセージ（部屋の説明：ステータスコードの意味など） |
| visitedAt | Visitor Logを登録した日時 |

### VisitorLogで使用する型

| フィールド名 | 型 |
| --- | --- |
| id | int |
| visitorName | String |
| roomCode | int（Stringで受け取ってからintへ変換） |
| message | String |
| visitedAt | String |

---

## 演習6 クラス設計

| クラス名 | 役割 |
| --- | --- |
| Main | アプリケーションの開始、各クラスの生成、メニュー処理の全体制御 |
| VisitorLog | Visitor Logのデータを保持するModelクラス |
| VisitorLogRepository | VisitorLogをArrayListで保管し、保存・取得・検索・削除を行う |
| VisitorLogService | 各VisitorLog Serviceで共通して使用するRepositoryを保持する親クラス |
| VisitorLogCreateService | Visitor Logの登録処理 |
| VisitorLogReadService | Visitor Logの一覧取得・ID検索 |
| VisitorLogUpdateService | Visitor Logの更新処理 |
| VisitorLogDeleteService | Visitor Logの削除処理 |
| Menu | 各Menuがshow()を持つことを決めるインターフェース |
| MainMenu | メインメニューの表示とメニュー番号の入力受付 |
| CreateMenu | Visitor Log登録時の入力・表示 |
| ListMenu | Visitor Log一覧の表示 |
| DetailMenu | Visitor Log詳細の入力・表示 |
| UpdateMenu | Visitor Log編集時の入力・表示 |
| DeleteMenu | Visitor Log削除時の入力・確認・表示 |
| SearchMenu | ID検索時の入力・表示 |
| VisitorLogCommonUI | Visitor Logの共通表示処理 |
| InputValidator | 空文字・数値・メニュー番号などの入力チェック |
| HttpStatus | HTTPステータスコードとメッセージを管理するenum |

---

## 簡易クラス図

```text
Main
 │
 ├── MainMenu
 │
 ├── Menu
 │    ├── CreateMenu
 │    ├── ListMenu
 │    ├── DetailMenu
 │    ├── UpdateMenu
 │    ├── DeleteMenu
 │    └── SearchMenu
 │
 ├── VisitorLogCommonUI
 │
 ├── VisitorLogService
 │    ├── VisitorLogCreateService
 │    ├── VisitorLogReadService
 │    ├── VisitorLogUpdateService
 │    └── VisitorLogDeleteService
 │
 ├── VisitorLogRepository
 │    └── List<VisitorLog>
 │
 ├── VisitorLog
 │
 ├── InputValidator
 │
 └── HttpStatus
