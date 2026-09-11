# cloud-itonami-municipality-jpn-osaka

Municipal-ordinance compliance catalog for **Osaka** (大阪市) —
a Wave 1b addition per ADR-2607171400 addendum 2, joining the
`cloud-itonami-municipality-*` compliance-fact family of ADR-2607141700
(`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`;
see e.g.
[`cloud-itonami-municipality-jpn-tokyo`](https://github.com/cloud-itonami/cloud-itonami-municipality-jpn-tokyo)
and
[`cloud-itonami-municipality-ita-roma`](https://github.com/cloud-itonami/cloud-itonami-municipality-ita-roma)).
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on the City of Osaka's
behalf.

Coverage is reported honestly (see `ordinance.facts/coverage`): a
municipality not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/ordinance/facts.cljk` — the catalog, source of truth.
- `schema/ordinance.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

Both entries were verified on 2026-07-17 against official
city.osaka.lg.jp sources: the **大阪市路上喫煙の防止に関する条例**
(平成19年大阪市条例第54号 — full text read on the official page, whose
附則 records entry into force on 2007-04-01 and the latest amendment,
条例第58号, promulgated 2024-03-29; the 条例番号 is printed on the
city's official designated-no-smoking-zones page) and the
**大阪市自転車駐車場の附置等に関する条例** (制定 平成22年2月26日
条例第4号, 最近改正 平成28年3月1日 条例第30号 — verified by directly
reading the official PDF's title header).

## Culture catalog

Alongside the ordinance catalog, this repo carries a **regional-culture
catalog** (ADR-2607171400, `cloud-itonami-municipality-culture-catalog`
in `com-junkawasaki/root`) — local dishes, festivals and heritage sites
for Osaka:

- `src/culture/facts.cljk` — the catalog, source of truth.
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

Same provenance discipline as the ordinance catalog: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Ordinance text
itself remains the City of Osaka's; this repo stores only citation
metadata (id/title/url/dates), not full text.
