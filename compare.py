import json, collections

def load(path):
    c = collections.Counter()
    for r in json.load(open(path))["results"]:
        c[(r["check_id"], r["path"])] += 1
    return c

b, a = load("semgrep-baseline.json"), load("semgrep-after.json")
for k in sorted(set(a) | set(b)):
    d = a[k] - b[k]
    if d:
        print(f"{d:+d}\t{k[0]}\t{k[1]}")
print("baseline:", sum(b.values()), "| apres:", sum(a.values()))
